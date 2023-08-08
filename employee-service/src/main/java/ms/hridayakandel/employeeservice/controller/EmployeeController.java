package ms.hridayakandel.employeeservice.controller;

import lombok.AllArgsConstructor;
import ms.hridayakandel.employeeservice.dto.APIResponseDto;
import ms.hridayakandel.employeeservice.dto.EmployeeDto;
import ms.hridayakandel.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeByID(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
