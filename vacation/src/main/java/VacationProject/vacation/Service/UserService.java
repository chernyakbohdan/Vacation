package VacationProject.vacation.Service;

import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    User addUser(User user);
    Optional<UserDTO> findByEmail(String email);
    User updateUser(User user);
    void deleteUser(String email);

    List<String> findDistinctAppointments();
}
