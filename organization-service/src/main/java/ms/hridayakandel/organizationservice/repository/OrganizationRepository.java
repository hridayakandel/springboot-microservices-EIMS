package ms.hridayakandel.organizationservice.repository;

import ms.hridayakandel.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findOrganizationByOrganizationCode(String organizationCode);

}
