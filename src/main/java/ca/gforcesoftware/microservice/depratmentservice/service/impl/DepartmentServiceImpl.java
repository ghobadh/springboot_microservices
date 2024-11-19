package ca.gforcesoftware.microservice.depratmentservice.service.impl;

import ca.gforcesoftware.microservice.depratmentservice.dto.DepartmentDto;
import ca.gforcesoftware.microservice.depratmentservice.entity.Department;
import ca.gforcesoftware.microservice.depratmentservice.mapper.DepartmentMapper;
import ca.gforcesoftware.microservice.depratmentservice.repository.DepartmentRepository;
import ca.gforcesoftware.microservice.depratmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-18
 */
@Service
@Data
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.toDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartment(Long id) {
        return DepartmentMapper
                .toDepartmentDto(departmentRepository
                        .findById(id)
                        .orElseThrow( () ->  new RuntimeException("Department with id " + id + " not found")));
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository
                .findAll()
                .stream()
                .map(DepartmentMapper::toDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        return  DepartmentMapper
                .toDepartmentDto(departmentRepository
                        .findByDepartmentCode(code)
                        .orElseThrow( () -> new RuntimeException("Department with code " + code + " not found")));

    }


}
