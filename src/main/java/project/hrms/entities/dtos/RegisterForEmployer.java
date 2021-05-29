package project.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployer  {
    private String email;
    private String password;
    private String companyName;
    private String webAddress;
    private String phoneNumber;
    private String confirmPassword;
}
