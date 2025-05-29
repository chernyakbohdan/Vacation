package VacationProject.vacation.Controller;

import VacationProject.vacation.Dto.AdminDTO;
import VacationProject.vacation.Entity.Admin;
import VacationProject.vacation.Service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AdminController {
    private final AdminService service;

    @GetMapping
    public List<Admin> getAllAdmins(){
        return service.findAllAdmin();
    }
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return service.addAdmin(admin);
    }

    @GetMapping("/{email}")
    public Optional<AdminDTO> getAdmin(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PutMapping("updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return service.updateAdmin(admin);
    }

    @DeleteMapping("deleteAdmin/{email}")
    public void deleteAdmin(@PathVariable String email) {
        service.deleteAdmin(email);
    }
}
