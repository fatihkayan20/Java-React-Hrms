package project.hrms.entities.dtos;

import lombok.Data;

@Data
public class RegisterForCandidate  {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String  dateOfBirth;
    private String confirmPassword;

}
