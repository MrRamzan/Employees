package kg.megacom.EmployeeApp.Dao;

import kg.megacom.EmployeeApp.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
