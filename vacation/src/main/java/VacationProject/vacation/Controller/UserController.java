package VacationProject.vacation.Controller;

import VacationProject.vacation.Dto.Mapping.UserMapping;
import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;
import VacationProject.vacation.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapping userMapping;

    @GetMapping("menu")
    public String menu(Model model) {
        List<User> users = service.findAllUser();
        model.addAttribute("getUsers", users);
        return "menu";
    }

    @GetMapping("registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("registration")
    public String registration(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        User createdUser = service.addUser(new User(email, password));
        redirectAttributes.addAttribute("userId", createdUser.getId()) ;
        return "redirect:/fill_data";
    }

    @GetMapping("log-in")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("log-in")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if(service.login(email, password).isPresent()) {
            return "redirect:/log-in";
        }
        else{
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("fill_data")
    public String fillUserData(@RequestParam("userId") Long userId, Model model) {
        UserDTO createdUser = service.findById(userId)
                .orElseThrow(() -> new RuntimeException("createdUser with id not found."));
        model.addAttribute("user", createdUser);
        return "fillUserData";
    }

    @PostMapping("fill_data")
    public String fillUserData(@ModelAttribute("user") UserDTO userDTO, Model model) {
        service.updateUser(userDTO);
        return "redirect:/menu";
    }



    @GetMapping("allUsers")
    public String getAllUsers(Model model) {
        List <User> users = service.findAllUser();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/user/add")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/user/add")
    public String addUser(User user, Model model) {
        User createdUser = service.addUser(user);
        model.addAttribute("user", createdUser);
        return "userResult";
    }

    @PostMapping("addUser")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("getUser/{email}")
    @ResponseBody
    public Optional<UserDTO> getUser(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/Appointments")
    @ResponseBody
    public List<String> getAllUserAppointments() {
        return service.findDistinctAppointments();
    }

    @PutMapping("updateUser")
    @ResponseBody
    public UserDTO updateUser(@RequestBody User user) {
        return service.updateUser(userMapping.userToUserDTO(user));
    }

    @DeleteMapping("deleteUser/{email}")
    @ResponseBody
    public void deleteUser(@PathVariable String email) {
        service.deleteUser(email);
    }
}
