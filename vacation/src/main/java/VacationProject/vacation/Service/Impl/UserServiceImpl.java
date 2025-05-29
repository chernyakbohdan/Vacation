package VacationProject.vacation.Service.Impl;

import VacationProject.vacation.Dto.Mapping.UserMapping;
import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;
import VacationProject.vacation.Service.UserService;
import VacationProject.vacation.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final UserMapping Usermapping;

    @Override
    public List<User> findAllUser() {
        //todo
        return repo.findAll();
    }

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return repo.findUserByEmail(email)
                .map(Usermapping::userToUserDTO);
    }

    @Override
    public User updateUser(User user) {
        return repo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
    repo.deleteByEmail(email);
    }

    @Override
    public List<String> findDistinctAppointments(){
        return repo.findAllAppoint();
    }
}
