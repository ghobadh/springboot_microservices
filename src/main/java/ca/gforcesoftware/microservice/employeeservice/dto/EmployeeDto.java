package ca.gforcesoftware.microservice.employeeservice.dto;

import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gavinhashemi on 2024-11-18
 */

public record EmployeeDto(
     Long id,
     String firstName,
     String lastName,
     String email, String departmentCode) {
}
