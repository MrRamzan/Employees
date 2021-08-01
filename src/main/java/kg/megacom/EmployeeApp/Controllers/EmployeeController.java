package kg.megacom.EmployeeApp.Controllers;

import kg.megacom.EmployeeApp.Models.Response.Response;
import kg.megacom.EmployeeApp.Models.dto.EmplSalaryDto;
import kg.megacom.EmployeeApp.Models.dto.EmployeeDto;
import kg.megacom.EmployeeApp.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }

    @GetMapping("/getById/{id}")
    public EmployeeDto getId(@RequestParam Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/update")
    public EmployeeDto updateInfo(Long id, EmployeeDto employeeDto) {
        return employeeService.update(id, employeeDto);
    }

    @PostMapping("/saveNewEmployeeWithSalary")
    public Response saveNewEmployeeSalary(@RequestBody EmplSalaryDto emplSalaryDto) {
        return employeeService.saveNewEmployeeSalary(emplSalaryDto);
    }

}
