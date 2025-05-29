package VacationProject.vacation.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    String email;
    String name;
    String last_name;
    String appointment;
    String work_experience;
    String phone;
    int age;
}
