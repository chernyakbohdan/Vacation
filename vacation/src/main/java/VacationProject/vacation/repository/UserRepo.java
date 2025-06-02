package VacationProject.vacation.repository;

import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.Admin;
import VacationProject.vacation.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    void deleteByEmail(String email);

    @Query(value = "SELECT DISTINCT appointment FROM user1", nativeQuery = true)
    List<String> findAllAppoint();
}
