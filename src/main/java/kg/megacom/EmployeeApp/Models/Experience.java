package kg.megacom.EmployeeApp.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "experiences")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
    private Long id;
    private int years;
    private double coefficient;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
