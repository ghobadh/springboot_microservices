package ca.gforcesoftware.microservice.depratmentservice.dto;


/**
 * @author gavinhashemi on 2024-11-18
 */
public record DepartmentDto (
    Long id,
    String departmentName,
    String departmentCode,
    String departmentDescription ){ }
