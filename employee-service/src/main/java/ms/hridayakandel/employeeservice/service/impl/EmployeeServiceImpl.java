package ms.hridayakandel.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import ms.hridayakandel.employeeservice.dto.APIResponseDto;
import ms.hridayakandel.employeeservice.dto.DepartmentDto;
import ms.hridayakandel.employeeservice.dto.EmployeeDto;
import ms.hridayakandel.employeeservice.entity.Employee;
import ms.hridayakandel.employeeservice.exceptions.ResourceNotFoundException;
import ms.hridayakandel.employeeservice.mapper.AutoEmployeeMapper;
import ms.hridayakandel.employeeservice.repository.EmployeeRepository;
import ms.hridayakandel.employeeservice.service.APIClient;
import ms.hridayakandel.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
  // private ModelMapper modelMapper;
    private WebClient webClient;
    //private APIClient apiClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
      // Employee employee = modelMapper.map(employeeDto,Employee.class);
      Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//
//                );
        Employee saveEmployee = employeeRepository.save(employee);
//        EmployeeDto saveEmployeeDto = new EmployeeDto(
//                saveEmployee.getId(),
//                saveEmployee.getFirstName(),
//                saveEmployee.getLastName(),
//                saveEmployee.getEmail()
//                );
        //EmployeeDto saveEmployeeDto = modelMapper.map(saveEmployee,EmployeeDto.class);
        EmployeeDto saveEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(saveEmployee);

        return saveEmployeeDto;
    }
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeByID(Long employeeId) {
        LOGGER.info("Inside getEmployeeByID() method");

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isPresent()) {

            //        EmployeeDto employeeDto = new EmployeeDto(
            //                employee.getId(),
            //                employee.getFirstName(),
            //                employee.getLastName(),
            //                employee.getEmail()
            //                );
            // EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

//            ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.get().getDepartmentCode(), DepartmentDto.class);
//            DepartmentDto departmentDto = responseEntity.getBody();

           DepartmentDto departmentDto=  webClient.get()
                    .uri("http://localhost:8080/api/departments/"+ employee.get().getDepartmentCode())
                    .retrieve()
                    .bodyToMono(DepartmentDto.class)
                    .block();
           // DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.get().getDepartmentCode());
            EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee.get());
            APIResponseDto apiResponseDto = new APIResponseDto(
                    employeeDto,departmentDto
            );

            return apiResponseDto;
        }
        else {
            throw new ResourceNotFoundException("Employee","Id",employeeId);
        }
    }
    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception){
        LOGGER.info("Inside getDefaultDepartment() method");

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isPresent()) {

            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDepartmentName("R&D department");
            departmentDto.setDepartmentCode("RD001");
            departmentDto.setDepartmentDescription("Research and development department");

            EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee.get());
            APIResponseDto apiResponseDto = new APIResponseDto(
                    employeeDto,departmentDto
            );

            return apiResponseDto;
        }
        else {
            throw new ResourceNotFoundException("Employee","Id",employeeId);
        }
    }
}
