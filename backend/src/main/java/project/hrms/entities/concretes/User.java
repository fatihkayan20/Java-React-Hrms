package project.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="is_deleted")
    @JsonIgnore
    private boolean is_deleted=false;

    @Column(name="is_activated")
    private boolean is_activated= false;

    @Column(name="updated_date")
    private LocalDate updatedDate;

    @Column(name="created_date")
    private LocalDate createdDate = LocalDate.now();

    public User(String email, String password) {
        this.email =email;
        this.password = password;
    }
}
