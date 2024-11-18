package ca.gforcesoftware.microservice.employeeservice.mapper;

import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;

/**
 * @author gavinhashemi on 2024-11-18
 */
public class EmployeeMapper {
    public static Employee toEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.id(),
                employeeDto.firstName(),
                employeeDto.lastName(),
                employeeDto.email()
        );
    }

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
