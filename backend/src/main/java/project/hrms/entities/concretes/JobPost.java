package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_posts")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employment_type_id")
    private  EmploymentType employmentType;

    @Column(name = "quota")
    private int quota;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "description")
    private String description;

    @Column(name = "is_remote")
    private boolean isRemote ;

    @Column(name = "is_activated")
    @JsonIgnore
    private boolean isActivated = true;

    @Column(name = "is_deleted")
    @JsonIgnore
    private boolean isDeleted;

    @Column(name = "appeal_deadline")
    private LocalDate appealDeadline;

    @Column(name = "deleted_date")
    @JsonIgnore
    private LocalDate deletedDate;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();



}
