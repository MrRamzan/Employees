package kg.megacom.EmployeeApp.Models.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private boolean active;

}
