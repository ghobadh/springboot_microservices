package ca.gforcesoftware.microservice.depratmentservice.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gavinhashemi on 2024-11-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="dept_name" ,nullable = false)
    private String departmentName;
    @Column(name="dept_code")
    private String departmentCode;
    @Column(name = "dept_desc")
    private String departmentDescription;
}
