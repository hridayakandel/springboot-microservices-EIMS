package ms.hridayakandel.departmentservice.controller;

import lombok.AllArgsConstructor;
import ms.hridayakandel.departmentservice.dto.DepartmentDto;
import ms.hridayakandel.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class departmentController {
    private DepartmentService departmentService;

    //saving Department REST Api
    @PostMapping
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
       //return new ResponseEntity<>("created", HttpStatus.CREATED);

    }
    //get Department by code REST Api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByDepatmentCode(@PathVariable("department-code")  String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}