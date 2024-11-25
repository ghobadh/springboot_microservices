package ca.gforcesoftware.microservice.employeeservice.service.impl;

import ca.gforcesoftware.microservice.employeeservice.dto.APIResponseDto;
import ca.gforcesoftware.microservice.employeeservice.dto.DepartmentDto;
import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.dto.OrganizationDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import ca.gforcesoftware.microservice.employeeservice.exception.ResourceNotFoundException;
import ca.gforcesoftware.microservice.employeeservice.mapper.EmployeeMapper;
import ca.gforcesoftware.microservice.employeeservice.repository.EmployeeRepository;
import ca.gforcesoftware.microservice.employeeservice.service.APIClient;
import ca.gforcesoftware.microservice.employeeservice.service.APIOrganizationClient;
import ca.gforcesoftware.microservice.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-18
 */
@Service
@Slf4j
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final APIOrganizationClient aPIOrganizationClient;
    private EmployeeRepository employeeRepository;
    // I commented in to use WebClient instead
    //  private RestTemplate restTemplate;

    // I commented in to use Feign instead
    // private WebClient webClient;

    private APIClient apiClient;
    private APIOrganizationClient apiOrganizationClient;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDto));
        return EmployeeMapper.INSTANCE.toEmployeeDto(savedEmployee);
    }


    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        log.info(" --> method getEmployeeById() id called");
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

        //This is for Webclient part
//        DepartmentDto departmentDto = webClient
//                .get()
//                .uri("http://localhost:8080/dept/code/" +
//                        employeeDto.departmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

// This is for Spring Cloud Feign
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employeeDto.departmentCode());
        OrganizationDto organizationDto = apiOrganizationClient.getOrganization(employeeDto.organizationCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper.INSTANCE::toEmployeeDto).collect(Collectors.toList());
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
        log.info(" --> method getDefaultDepartment() id called");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(id);
        departmentDto.setDepartmentCode("UNKOWN CODE");
        departmentDto.setDepartmentDescription("CIRCUIT BREAKER RESPONSE");
        departmentDto.setDepartmentName("UNKOWN NAME");
        EmployeeDto employeeDto = employeeRepository
                .findById(id)
                .map(EmployeeMapper.INSTANCE::toEmployeeDto)
                .orElseThrow(
                        () ->  new ResourceNotFoundException("employee with id " + id + " not found")
                );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
