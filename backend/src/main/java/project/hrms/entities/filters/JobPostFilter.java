package project.hrms.entities.filters;

import lombok.Data;
import project.hrms.entities.concretes.City;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.EmploymentType;
import project.hrms.entities.concretes.JobPosition;

import java.time.LocalDate;

@Data
public class JobPostFilter {
    private Employer employer;
    private JobPosition jobPosition;
    private City city;
    private EmploymentType employmentType;
    private int quota;
    private double minSalary;
    private double maxSalary;
    private String description;
    private boolean isRemote ;
    private boolean isActivated = false;
    private boolean isDeleted;
    private LocalDate appealDeadline;
    private LocalDate deletedDate;
    private LocalDate createdDate = LocalDate.now();

}
