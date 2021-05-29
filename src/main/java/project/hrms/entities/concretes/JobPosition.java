package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosts"})
@Table(name="job_positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @JsonIgnore
    @Column(name="is_activated")
    private boolean isActivated;

    @JsonIgnore
    @Column(name="is_deleted")
    private boolean isDeleted;

    @JsonIgnore
    @Column(name="updated_date")
    private LocalDate updatedDate;

    @JsonIgnore
    @Column(name="created_date")
    private LocalDate createdDate = LocalDate.now() ;

    @OneToMany(mappedBy = "employer")
    private List<JobPost> jobPosts;
}
