package kg.megacom.EmployeeApp.Services.impl;

import kg.megacom.EmployeeApp.Dao.SalaryRepository;
import kg.megacom.EmployeeApp.Mappers.SalaryMapper;
import kg.megacom.EmployeeApp.Models.Salary;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import kg.megacom.EmployeeApp.Models.dto.SalaryDto;
import kg.megacom.EmployeeApp.Services.SalaryService;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    private SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public SalaryDto saveNewSalary(SalaryDto salaryDto, EmployeeDto employeeDto) {
        salaryDto.setEmployee(employeeDto);
        Salary salary = salaryRepository.save(SalaryMapper.INSTANCE.salaryDtoToSalary(salaryDto));
        return SalaryMapper.INSTANCE.salaryToSalaryDto(salary);
    }

}
