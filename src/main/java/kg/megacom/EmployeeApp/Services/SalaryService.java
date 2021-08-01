package kg.megacom.EmployeeApp.Services;

import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import kg.megacom.EmployeeApp.Models.dto.SalaryDto;

public interface SalaryService {

    SalaryDto saveNewSalary (SalaryDto salaryDto, EmployeeDto employeeDto);

}
