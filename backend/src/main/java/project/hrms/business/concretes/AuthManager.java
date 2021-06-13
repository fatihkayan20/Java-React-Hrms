package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.AuthService;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccesResult;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.dtos.RegisterForCandidate;
import project.hrms.entities.dtos.RegisterForEmployer;

@Service
public class AuthManager implements AuthService {

    private CandidateService candidateService;
    private EmployerService employerService;

    @Autowired
    public AuthManager(CandidateService candidateService, EmployerService employerService) {
        this.candidateService = candidateService;
        this.employerService = employerService;
    }

    @Override
    public Result candidateRegister(RegisterForCandidate candidateDto) {
        var result = BusinessRule.run(checkConfirmPasswordValid(candidateDto.getConfirmPassword()), checkConfirmPasswordAndPasswordMatch(candidateDto.getConfirmPassword(),candidateDto.getPassword()));
        if (!result.isSuccess()){

            return result;
        }

        Candidate candidate= new Candidate(candidateDto.getEmail(),candidateDto.getPassword(),candidateDto.getFirstName(), candidateDto.getLastName(),candidateDto.getNationalIdentity(),candidateDto.getDateOfBirth());
        return candidateService.add(candidate);

    }

    @Override
    public Result employerRegister(RegisterForEmployer employerDto) {
        var result = BusinessRule.run(checkConfirmPasswordValid(employerDto.getConfirmPassword()), checkConfirmPasswordAndPasswordMatch(employerDto.getConfirmPassword(),employerDto.getPassword()));
        if (!result.isSuccess()){
            return result;
        }

        Employer employer= new Employer(employerDto.getEmail(),employerDto.getPassword(),employerDto.getCompanyName(),employerDto.getWebAddress(),employerDto.getPhoneNumber());
        return this.employerService.add(employer);

    }

    private Result checkConfirmPasswordValid(String confirmPassword){
        if(confirmPassword == null || confirmPassword.isBlank()){
            return new ErrorResult("All fields are required");
        }
        return new SuccesResult();
    }
    private Result checkConfirmPasswordAndPasswordMatch(String confirmPassword, String password){
        if(!confirmPassword.equals(password)){
            return new ErrorResult("Passwords must match");
        }
        return new SuccesResult();
    }
}
