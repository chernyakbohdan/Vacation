package VacationProject.vacation.Dto.Mapping;

import VacationProject.vacation.Dto.UserDTO;
import VacationProject.vacation.Entity.User;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
@Primary
public interface UserMapping {
    UserDTO userToUserDTO(User user);
}
