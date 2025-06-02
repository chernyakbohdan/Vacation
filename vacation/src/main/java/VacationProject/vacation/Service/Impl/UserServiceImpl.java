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

    private final UserMapping Usermapping;
    private final UserRepo repo;

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
    public Optional<UserDTO> findById(Long id) {
        return repo.findUserById(id)
                .map(Usermapping::userToUserDTO);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User foundUser = repo.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User with id " + userDTO.getId() + " not found."));
        foundUser.setAppointment(userDTO.getAppointment());
        foundUser.setExperience(userDTO.getExperience());
        foundUser.setDateOfBirth(userDTO.getDateOfBirth());
        foundUser.setPhone(userDTO.getPhone());
        foundUser.setAge(userDTO.getAge());
        foundUser.setName(userDTO.getName());

        User updatedEntity = repo.save(foundUser);
        return Usermapping.userToUserDTO(updatedEntity);
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

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> user = repo.findUserByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
