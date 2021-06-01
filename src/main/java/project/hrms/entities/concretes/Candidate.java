package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="candidates")
public class Candidate extends User{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name="national_identity")
    private String nationalIdentity;

    @Column(name="date_of_birth")
    private String  dateOfBirth;

//    @OneToOne(mappedBy = "candidate")
//    @JoinColumn(name = "curriculum_vitae_id")
//    private CurriculumVitae curriculumVitae;


    public Candidate(String email,String password,String firstName, String lastName, String nationalIdentity, String  dateOfBirth) {
        super(email,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
    }
}