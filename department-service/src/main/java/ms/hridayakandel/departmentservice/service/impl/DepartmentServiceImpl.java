package ms.hridayakandel.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import ms.hridayakandel.departmentservice.dto.DepartmentDto;
import ms.hridayakandel.departmentservice.entity.Department;
import ms.hridayakandel.departmentservice.exceptions.DepartmentAlreadyExistsException;
import ms.hridayakandel.departmentservice.exceptions.ResourceNotFoundException;
import ms.hridayakandel.departmentservice.mapper.AutoDepartmentMapper;
import ms.hridayakandel.departmentservice.repository.DepartmentRepository;
import ms.hridayakandel.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    //no need @Autowired because there is single parametrized constructor so spring will automatically inject dependency
    private DepartmentRepository departmentRepository;
   // private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // DepartmentDto to Department Jpa entity
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );
        //Department department = modelMapper.map(departmentDto,Department.class);
        Optional<Department> departmeByCode = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if(departmeByCode.isPresent()){
            throw new DepartmentAlreadyExistsException("Department",departmentDto.getDepartmentCode(),"exists");
        }else{
            Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
            Department saveDepartment = departmentRepository.save(department);
            DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(saveDepartment);
            return savedDepartmentDto;

        }

        //System.out.println(saveDepartment);
//        DepartmentDto savedDepartmentDto = new DepartmentDto(
//                saveDepartment.getId(),
//                saveDepartment.getDepartmentName(),
//                saveDepartment.getDepartmentDescription(),
//                saveDepartment.getDepartmentCode()
//        );
        //DepartmentDto savedDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);

    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        if(department==null){
            throw new ResourceNotFoundException("Department","Code",departmentCode);
        }
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        //DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
