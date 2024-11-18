package ca.gforcesoftware.microservice.depratmentservice.service;

import ca.gforcesoftware.microservice.depratmentservice.dto.DepartmentDto;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-18
 */
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(Long id);
    List<DepartmentDto> getAllDepartments();
}
