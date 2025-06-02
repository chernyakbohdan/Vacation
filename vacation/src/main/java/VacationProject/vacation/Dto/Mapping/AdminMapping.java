package VacationProject.vacation.Dto.Mapping;

import VacationProject.vacation.Dto.AdminDTO;
import VacationProject.vacation.Entity.Admin;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
@Primary
public interface AdminMapping {
    AdminDTO toDto(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
}
