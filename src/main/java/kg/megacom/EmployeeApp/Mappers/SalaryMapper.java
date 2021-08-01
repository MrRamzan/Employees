package kg.megacom.EmployeeApp.Mappers;

import kg.megacom.EmployeeApp.Models.Salary;
import kg.megacom.EmployeeApp.Models.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalaryMapper {

    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    SalaryDto salaryToSalaryDto(Salary salary);

    Salary salaryDtoToSalary(SalaryDto salaryDto);

    List<SalaryDto> salaryListToSalaryDtoList(List<Salary> salaryList);

    List<Salary> salaryDtoListToSalaryList(List<SalaryDto> salaryDtoList);
}
