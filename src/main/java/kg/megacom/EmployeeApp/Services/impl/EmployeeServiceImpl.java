package kg.megacom.EmployeeApp.Services.impl;

import kg.megacom.EmployeeApp.Dao.EmployeeRepository;
import kg.megacom.EmployeeApp.Mappers.EmployeeMapper;
import kg.megacom.EmployeeApp.Mappers.EmployeeSalaryMapper;
import kg.megacom.EmployeeApp.Models.Employee;
import kg.megacom.EmployeeApp.Models.Response.Response;
import kg.megacom.EmployeeApp.Models.dto.EmplSalaryDto;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import kg.megacom.EmployeeApp.Models.dto.SalaryDto;
import kg.megacom.EmployeeApp.Services.EmployeeService;
import kg.megacom.EmployeeApp.Services.SalaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private SalaryService salaryService;
    Response response = new Response();

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, SalaryService salaryService) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }


    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = EmployeeMapper.INSTANCE.employeeListToEployeeDtoList(employeeList);
        return employeeDtoList;
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee empl = employeeRepository.findById(id).orElse(null);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(empl);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee empl = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        empl = employeeRepository.save(empl);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(empl);
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        EmployeeDto employeeFromDb = findById(employeeDto.getId());
        if (employeeFromDb == null) {
            throw new RuntimeException("Employee not found");
        }
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);
    }

    @Override
    public Response saveNewEmployeeSalary(EmplSalaryDto emplSalaryDto) {
        EmployeeDto employeeDto = EmployeeSalaryMapper.INSTANCE.toEmployeeDto(emplSalaryDto);
        SalaryDto salaryDto = EmployeeSalaryMapper.INSTANCE.toSalaryDto(emplSalaryDto);
        EmployeeDto saving = saveNewEmployee(employeeDto);
        SalaryDto salaryDto1 = salaryService.saveNewSalary(salaryDto, saving);

        if (salaryDto1.getId() != null) {
            response.setCode(1);
            response.setMessage("Объект успешно сохранён");
            return response;
        }
        response.setCode(0);
        response.setMessage("Повторите попытку");
        return response;
    }

    private EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {
        Employee employeeFromDb = employeeRepository.findByFirstNameAndLastName(employeeDto.getFirstName(), employeeDto.getLastName());
        if (employeeFromDb == null) {
            Employee employeeForSave = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
            Employee employee = employeeRepository.save(employeeForSave);
            return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee);
        }
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employeeFromDb);
    }

}
