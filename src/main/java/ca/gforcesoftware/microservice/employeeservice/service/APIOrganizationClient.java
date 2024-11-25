package ca.gforcesoftware.microservice.employeeservice.service;

import ca.gforcesoftware.microservice.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gavinhashemi on 2024-11-23
 */
@FeignClient("organization-service")
public interface APIOrganizationClient {

    @GetMapping("/api/org/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String code);
}
