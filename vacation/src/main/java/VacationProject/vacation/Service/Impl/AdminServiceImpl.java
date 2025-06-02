package VacationProject.vacation.Service.Impl;

import VacationProject.vacation.Dto.AdminDTO;
import VacationProject.vacation.Dto.Mapping.AdminMapping;
import VacationProject.vacation.Entity.Admin;
import VacationProject.vacation.Service.AdminService;
import VacationProject.vacation.repository.AdminRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepo repo;
    private final AdminMapping mapping;

    @Override
    public List<Admin> findAllAdmin() {
        return repo.findAll();
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return repo.save(admin);
    }

    @Override
    public Optional<AdminDTO> findByEmail(String email) {
        return repo.findAdminByEmail(email).map(mapping::toDto);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return repo.save(admin);
    }

    @Override
    @Transactional
    public void deleteAdmin(String email) {
        repo.deleteByEmail(email);
    }
}
