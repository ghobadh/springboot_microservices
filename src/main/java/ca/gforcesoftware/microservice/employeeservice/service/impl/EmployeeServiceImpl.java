package ca.gforcesoftware.microservice.employeeservice.service.impl;

import ca.gforcesoftware.microservice.employeeservice.dto.APIResponseDto;
import ca.gforcesoftware.microservice.employeeservice.dto.DepartmentDto;
import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import ca.gforcesoftware.microservice.employeeservice.exception.ResourceNotFoundException;
import ca.gforcesoftware.microservice.employeeservice.mapper.EmployeeMapper;
import ca.gforcesoftware.microservice.employeeservice.repository.EmployeeRepository;
import ca.gforcesoftware.microservice.employeeservice.service.EmployeeService;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-18
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    // I commented in to use WebClient instead
    //  private RestTemplate restTemplate;

    private WebClient webClient;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDto));
        return EmployeeMapper.INSTANCE.toEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        EmployeeDto employeeDto = employeeRepository
                .findById(id)
                .map(EmployeeMapper.INSTANCE::toEmployeeDto)
                .orElseThrow(
                        () ->  new ResourceNotFoundException("employee with id " + id + " not found")
                );
//        ResponseEntity<DepartmentDto> departmentDtoResp = restTemplate
//                .getForEntity("http://localhost:8080/dept/code/" +
//                        employeeDto.departmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = departmentDtoResp.getBody();

        DepartmentDto departmentDto = webClient
                .get()
                .uri("http://localhost:8080/dept/code/" +
                        employeeDto.departmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();




        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper.INSTANCE::toEmployeeDto).collect(Collectors.toList());
    }
}
