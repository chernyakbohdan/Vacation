package VacationProject.vacation.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    Long id;
    String email;
    String name;
    String appointment;
    String experience;
    String phone;
    LocalDate dateOfBirth;
    int age;
}
