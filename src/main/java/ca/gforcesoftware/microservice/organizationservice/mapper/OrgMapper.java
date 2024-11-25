package ca.gforcesoftware.microservice.organizationservice.mapper;

import ca.gforcesoftware.microservice.organizationservice.dto.OrganizationDto;
import ca.gforcesoftware.microservice.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author gavinhashemi on 2024-11-23
 */
@Mapper
public interface OrgMapper {

    OrgMapper INSTANCE = Mappers.getMapper(OrgMapper.class);
    Organization  toOrganization(OrganizationDto organizationDto);
    OrganizationDto toOrganizationDto(Organization organization);
}
