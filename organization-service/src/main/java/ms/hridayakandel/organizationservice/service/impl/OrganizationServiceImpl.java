package ms.hridayakandel.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import ms.hridayakandel.organizationservice.dto.OrganizationDto;
import ms.hridayakandel.organizationservice.entity.Organization;
import ms.hridayakandel.organizationservice.mapper.OrganizationMapper;
import ms.hridayakandel.organizationservice.repository.OrganizationRepository;
import ms.hridayakandel.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization saveOrganization = organizationRepository.save(organization);
        OrganizationDto saorganizationDto = OrganizationMapper.mapToOrganizationDto(saveOrganization);
        return saorganizationDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findOrganizationByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
