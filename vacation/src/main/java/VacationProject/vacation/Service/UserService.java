package VacationProject.vacation.Service;

import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    User addUser(User user);
    Optional<UserDTO> findByEmail(String email);
    Optional<UserDTO> findById(Long id);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(String email);
    Optional<User> login(String email, String password);
    List<String> findDistinctAppointments();
}
