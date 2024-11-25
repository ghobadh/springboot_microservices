package ca.gforcesoftware.microservice.organizationservice.controller;

import ca.gforcesoftware.microservice.organizationservice.dto.OrganizationDto;
import ca.gforcesoftware.microservice.organizationservice.entity.Organization;
import ca.gforcesoftware.microservice.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/org")
public class OrgController {
    OrganizationService organizationService;

    @PostMapping("/new")
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrgDto = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(savedOrgDto, HttpStatus.CREATED);

    }

    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        OrganizationDto orgDto = organizationService.findOrganizationByCode(code);
        return new ResponseEntity<>(orgDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.findAllOrganizations());
    }

}
