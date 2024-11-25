package ca.gforcesoftware.microservice.organizationservice.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * @author gavinhashemi on 2024-11-23
 */
@Entity
@Data
@AllArgsConstructor
@Table(name="org")
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="org_name" , unique=true)
    private String organizationName;
    @Column(name="org_desc")
    private String organizationDescription;
    @Column(name="org_code", unique=true, nullable=false)
    private String organizationCode;
    @Column(name="create_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
