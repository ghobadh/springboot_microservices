package ca.gforcesoftware.microservice.employeeservice.service.impl;

import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import ca.gforcesoftware.microservice.employeeservice.mapper.EmployeeMapper;
import ca.gforcesoftware.microservice.employeeservice.repository.EmployeeRepository;
import ca.gforcesoftware.microservice.employeeservice.service.EmployeeService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-18
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee SavedEmployeeDto = employeeRepository.save(EmployeeMapper.toEmployee(employeeDto));
        return EmployeeMapper.toEmployeeDto(SavedEmployeeDto);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeMapper::toEmployeeDto)
                .orElseThrow(
                        () ->  new RuntimeException("employee with id " + id + " not found")
                );
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }
}
