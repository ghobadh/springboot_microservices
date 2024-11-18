package ca.gforcesoftware.microservice.employeeservice.controller;

import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import ca.gforcesoftware.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-18
 */
@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity<EmployeeDto> newEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);

    }

    //GET http://localhost:8081/employee?employee_id=2
    @GetMapping
    public ResponseEntity<EmployeeDto> getEmplpyee(@RequestParam (name="employee_id") Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

}
