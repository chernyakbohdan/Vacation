package VacationProject.vacation.repository;

import VacationProject.vacation.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    Optional<Admin> findAdminByEmail(String email);

    void deleteByEmail(String email);
}
