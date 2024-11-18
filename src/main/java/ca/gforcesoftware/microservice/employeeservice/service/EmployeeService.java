package ca.gforcesoftware.microservice.employeeservice.service;

import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-18
 */
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
}
