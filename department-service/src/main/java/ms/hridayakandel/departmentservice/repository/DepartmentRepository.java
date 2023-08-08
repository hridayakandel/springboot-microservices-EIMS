package ms.hridayakandel.departmentservice.repository;

import ms.hridayakandel.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findDepartmentByDepartmentCode(String departmentCode);

    Optional<Department> findByDepartmentCode(String departmentCode);
}
