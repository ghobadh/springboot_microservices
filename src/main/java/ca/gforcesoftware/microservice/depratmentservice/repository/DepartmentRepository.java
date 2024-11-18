package ca.gforcesoftware.microservice.depratmentservice.repository;

import ca.gforcesoftware.microservice.depratmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gavinhashemi on 2024-11-18
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
