package ms.hridayakandel.organizationservice.controller;

import lombok.AllArgsConstructor;
import ms.hridayakandel.organizationservice.dto.OrganizationDto;
import ms.hridayakandel.organizationservice.entity.Organization;
import ms.hridayakandel.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organizations")
public class OrganizationController {
    private OrganizationService organizationService;
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto saveOrganization = organizationService.save(organizationDto);
        return new ResponseEntity<>(saveOrganization, HttpStatus.CREATED);
    }
    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByOrganizationCode(@PathVariable("organization-code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity(organizationDto,HttpStatus.OK);

    }
}
