package ca.gforcesoftware.microservice.depratmentservice.controller;

import ca.gforcesoftware.microservice.depratmentservice.dto.DepartmentDto;
import ca.gforcesoftware.microservice.depratmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author gavinhashemi on 2024-11-18
 */
@RestController
@RequestMapping("/dept")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/new")
    public ResponseEntity<DepartmentDto> newDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto) , HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(departmentService.getDepartment(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return  ResponseEntity.ok(departmentService.getAllDepartments());
    }
}
