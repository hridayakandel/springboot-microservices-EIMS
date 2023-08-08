package ms.hridayakandel.departmentservice.mapper;

import ms.hridayakandel.departmentservice.dto.DepartmentDto;
import ms.hridayakandel.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    //factory method to get AutoDepartmentMapper object using utility class
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);
    //abstract methods for mapping
     DepartmentDto mapToDepartmentDto(Department department);
     Department mapToDepartment(DepartmentDto departmentDto);
}
