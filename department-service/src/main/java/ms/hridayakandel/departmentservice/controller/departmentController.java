package ms.hridayakandel.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ms.hridayakandel.departmentservice.dto.DepartmentDto;
import ms.hridayakandel.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name ="Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for department-services"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class departmentController {
    private DepartmentService departmentService;

    //saving Department REST Api
    @Operation(
            summary = "Save department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
       //return new ResponseEntity<>("created", HttpStatus.CREATED);

    }
    //get Department by code REST Api
    @Operation(
            summary = "Get department REST API",
            description = "Get Department REST API is used to get  a department object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByDepatmentCode(@PathVariable("department-code")  String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}