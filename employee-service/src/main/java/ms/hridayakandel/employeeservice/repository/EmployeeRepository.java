package ms.hridayakandel.employeeservice.repository;

import ms.hridayakandel.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
