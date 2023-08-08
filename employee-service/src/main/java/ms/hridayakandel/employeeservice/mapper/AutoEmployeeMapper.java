package ms.hridayakandel.employeeservice.mapper;

import ms.hridayakandel.employeeservice.dto.EmployeeDto;
import ms.hridayakandel.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AutoEmployeeMapper {
    // define mapping methods
    //It is interface, and we cannot create object of interface
    //Mapstruct provides an implementation at complication time , we can use mapper utility class
    //mappers has factory calls to get the class
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDto employeeDto);
}
