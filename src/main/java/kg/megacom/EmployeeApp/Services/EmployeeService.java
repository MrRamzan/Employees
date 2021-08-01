package kg.megacom.EmployeeApp.Services;

import kg.megacom.EmployeeApp.Models.Response.Response;
import kg.megacom.EmployeeApp.Models.dto.EmplSalaryDto;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    Response saveNewEmployeeSalary(EmplSalaryDto emplSalaryDto);

}
