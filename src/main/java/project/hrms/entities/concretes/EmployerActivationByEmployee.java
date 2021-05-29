package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers_activation_by_employees")
public class EmployerActivationByEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//
//    @ManyToOne()
//    private Employer employer;
//
//    @ManyToOne()
//    private Employee employee;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "created_date")
    private LocalDate createdDate;


}
