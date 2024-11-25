package ca.gforcesoftware.microservice.organizationservice.service.impl;

import ca.gforcesoftware.microservice.organizationservice.dto.OrganizationDto;
import ca.gforcesoftware.microservice.organizationservice.entity.Organization;
import ca.gforcesoftware.microservice.organizationservice.mapper.OrgMapper;
import ca.gforcesoftware.microservice.organizationservice.repository.OrganizationRepository;
import ca.gforcesoftware.microservice.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-23
 */
@Service
@Data
@Slf4j
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    OrganizationRepository organizationRepository;


    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = OrgMapper.INSTANCE.toOrganization(organizationDto);
        Organization savedOorganization =organizationRepository.save(organization);
        return OrgMapper.INSTANCE.toOrganizationDto(savedOorganization);
    }

    @Override
    public OrganizationDto findOrganizationByCode(String organizationCode) {
        return OrgMapper.INSTANCE.toOrganizationDto(
                organizationRepository
                        .findByOrganizationCode(organizationCode)
                        .orElseThrow( () ->  new RuntimeException("Organization '"+ organizationCode +"' not found"))
        );
    }

    @Override
    public List<OrganizationDto> findAllOrganizations() {
        return organizationRepository
                .findAll()
                .stream()
                .map(OrgMapper
                        .INSTANCE::toOrganizationDto)
                .collect(Collectors.toList());
    }
}
