package ms.hridayakandel.organizationservice.service;

import ms.hridayakandel.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto save(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);

}
