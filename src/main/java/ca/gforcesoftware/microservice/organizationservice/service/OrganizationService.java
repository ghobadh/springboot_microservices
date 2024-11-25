package ca.gforcesoftware.microservice.organizationservice.service;

import ca.gforcesoftware.microservice.organizationservice.dto.OrganizationDto;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-23
 */
public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto findOrganizationByCode(String organizationCode);
    List<OrganizationDto> findAllOrganizations();
}
