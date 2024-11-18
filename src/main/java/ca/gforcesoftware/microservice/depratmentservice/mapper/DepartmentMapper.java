package ca.gforcesoftware.microservice.depratmentservice.mapper;

import ca.gforcesoftware.microservice.depratmentservice.dto.DepartmentDto;
import ca.gforcesoftware.microservice.depratmentservice.entity.Department;

/**
 * @author gavinhashemi on 2024-11-18
 */
public class DepartmentMapper {
    public static Department toDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.id(),
                departmentDto.departmentName(),
                departmentDto.departmentCode(),
                departmentDto.departmentDescription()
        );

    }

    public static DepartmentDto toDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription());

    }
}
