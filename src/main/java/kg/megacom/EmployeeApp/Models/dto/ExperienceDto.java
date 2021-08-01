package kg.megacom.EmployeeApp.Models.dto;

import lombok.Data;

@Data
public class ExperienceDto {

    private Long id;
    private int years;
    private double coefficient;
    private EmployeeDto employee;

}
