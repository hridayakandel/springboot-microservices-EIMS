package ms.hridayakandel.employeeservice.service;

import ms.hridayakandel.employeeservice.dto.APIResponseDto;
import ms.hridayakandel.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeByID(Long employeeId);
}
