package VacationProject.vacation.Service;

import VacationProject.vacation.Dto.AdminDTO;
import VacationProject.vacation.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> findAllAdmin();
    Admin addAdmin(Admin admin);
    Optional<AdminDTO> findByEmail(String email);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(String email);
}
