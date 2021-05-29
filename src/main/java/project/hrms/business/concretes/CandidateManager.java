package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final UserService userService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService) {
        this.candidateDao = candidateDao;
        this.userService= userService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> get(int id) {
        return new SuccessDataResult<>(candidateDao.findById(id).get());
    }

    @Override
    public Result add(Candidate candidate) {
        var isValid = BusinessRule.run(checkIfCandidateValid(candidate), checkIfEmailExists(candidate.getEmail()),checkIfNationalIdentityExists(candidate.getNationalIdentity()));

        if (!isValid.isSuccess()){
            return isValid;
        }

        candidateDao.save(candidate);
        return new SuccesResult("Added.");
    }

    @Override
    public Result delete(Candidate candidate) {
        candidateDao.delete(candidate);
        return new SuccesResult("Deleted.");
    }

    @Override
    public Result update(Candidate candidate) {
        candidateDao.save(candidate);
        return new SuccesResult("Updated.");
    }


    private Result checkIfCandidateValid(Candidate candidate){
        if(candidate.getFirstName() == null || candidate.getFirstName().isBlank()
            || candidate.getLastName() == null || candidate.getLastName().isBlank() ||
                candidate.getNationalIdentity() == null ||candidate.getNationalIdentity().isBlank() ||
                candidate.getDateOfBirth() == null || candidate.getEmail() ==null ||candidate.getEmail().isBlank() ||
                candidate.getPassword() == null ||candidate.getPassword().isBlank()
        ){
            return new ErrorResult("All fields are required");
        }
        return new SuccesResult();
    }

    private Result checkIfEmailExists(String email){
        var user = this.userService.getByEmail(email);
        if(user != null){
            return new ErrorResult("Email is already exists");
        }
        return new SuccesResult();
    }

    private Result checkIfNationalIdentityExists(String nationalIdentity){
        var user = this.candidateDao.getByNationalIdentity(nationalIdentity);
        if(user != null){
            return new ErrorResult("National identity is already exists");
        }
        return new SuccesResult();
    }
}
