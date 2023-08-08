package ms.hridayakandel.departmentservice.service;

import ms.hridayakandel.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByDepartmentCode(String departmentCode);
}
