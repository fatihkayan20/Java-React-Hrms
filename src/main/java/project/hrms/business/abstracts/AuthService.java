package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.dtos.RegisterForCandidate;
import project.hrms.entities.dtos.RegisterForEmployer;

public interface AuthService {
    Result candidateRegister(RegisterForCandidate candidateDto);
    Result employerRegister(RegisterForEmployer employerDto);
}
