package ca.gforcesoftware.microservice.employeeservice.mapper;

import ca.gforcesoftware.microservice.employeeservice.dto.EmployeeDto;
import ca.gforcesoftware.microservice.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author gavinhashemi on 2024-11-18
 */
@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(EmployeeDto employeeDto);
//    public static Employee toEmployee(EmployeeDto employeeDto) {
//        return new Employee(
//                employeeDto.id(),
//                employeeDto.firstName(),
//                employeeDto.lastName(),
//                employeeDto.email()
//        );
//    }

//    public static EmployeeDto toEmployeeDto(Employee employee) {
//        return new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//    }
}
