package kg.megacom.EmployeeApp.Models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SalaryDto {

    private Long id;
    private double salary;
    private Date startDate;
    private Date endDate;
    private EmployeeDto employeeDto;

}
