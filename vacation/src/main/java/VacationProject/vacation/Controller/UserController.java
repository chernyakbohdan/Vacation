package VacationProject.vacation.Controller;

import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;
import VacationProject.vacation.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService service;

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
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("deleteUser/{email}")
    @ResponseBody
    public void deleteUser(@PathVariable String email) {
        service.deleteUser(email);
    }
}
