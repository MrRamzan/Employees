package kg.megacom.EmployeeApp.Mappers;

import kg.megacom.EmployeeApp.Models.dto.EmplSalaryDto;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import kg.megacom.EmployeeApp.Models.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeSalaryMapper {

    EmployeeSalaryMapper INSTANCE = Mappers.getMapper(EmployeeSalaryMapper.class);

    EmployeeDto toEmployeeDto(EmplSalaryDto emplSalaryDto);

    SalaryDto toSalaryDto(EmplSalaryDto emplSalaryDto);
}
