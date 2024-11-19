package ca.gforcesoftware.microservice.depratmentservice.repository;

import ca.gforcesoftware.microservice.depratmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author gavinhashemi on 2024-11-18
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByDepartmentCode(String code);
}
