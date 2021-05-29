package project.hrms.entities.concretes;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {
    @Id
//    @OneToOne(mappedBy = "id")
//    private User user;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "activation_date")
    private LocalDate activationDate;

    @Column(name = "created_date")
    private LocalDate createdDate;
}


