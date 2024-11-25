package ca.gforcesoftware.microservice.organizationservice.repository;

import ca.gforcesoftware.microservice.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author gavinhashemi on 2024-11-23
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByOrganizationCode(String orgCode);
}
