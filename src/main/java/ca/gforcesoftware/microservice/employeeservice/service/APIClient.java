package ca.gforcesoftware.microservice.employeeservice.service;

import ca.gforcesoftware.microservice.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gavinhashemi on 2024-11-19
 */
//I am commenting this line, so I can use the load balancer from Eureka Service Registry
//@FeignClient(url="http://localhost:8080" , value = "DEPARTMENT-SERVICE")

//when the Eureka is running, Spring Cloud load balancer is working by default
@FeignClient(name="DEPRATMENT-SERVICE")
public interface APIClient {

    // This is exact department controller method in Department Service project, except
    //it has changed to a interface method definition.
    //For GetMapping Annotation, we need to put the full URL and URI is not sufficient
    @GetMapping("/dept/code/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String deptCode);
}
