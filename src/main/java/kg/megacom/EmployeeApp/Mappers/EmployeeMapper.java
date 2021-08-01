package kg.megacom.EmployeeApp.Mappers;

import kg.megacom.EmployeeApp.Models.Employee;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> employeeListToEployeeDtoList(List<Employee> employeeList);

    List<Employee> employeeDtoListToEmployeeList(List<EmployeeDto> employeeDtoList);
}
