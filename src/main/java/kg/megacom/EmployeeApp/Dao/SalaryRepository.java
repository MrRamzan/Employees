package kg.megacom.EmployeeApp.Dao;

import kg.megacom.EmployeeApp.Models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
