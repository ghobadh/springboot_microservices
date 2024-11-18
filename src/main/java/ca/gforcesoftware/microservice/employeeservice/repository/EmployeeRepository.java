package ca.gforcesoftware.microservice.employeeservice.repository;

import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gavinhashemi on 2024-11-18
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
