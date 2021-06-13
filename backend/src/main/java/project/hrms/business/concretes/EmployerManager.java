package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private final UserService userService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService) {
        this.employerDao = employerDao;
        this.userService= userService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll());
    }

    @Override
    public DataResult<Employer> get(int id) {
        return new SuccessDataResult<>(employerDao.findById(id).get());
    }

    @Override
    public Result add(Employer employer) {
        var result = BusinessRule.run(checkIfEmployerValid(employer),checkIfEmailExists(employer.getEmail()));
        if(!result.isSuccess()){
            return result;
        }
        employerDao.save(employer);
        return new SuccesResult("Added.");
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccesResult("Deleted.");
    }

    @Override
    public Result update(Employer employer) {
        employerDao.save(employer);
        return new SuccesResult("Updated.");
    }

    private Result checkIfEmployerValid(Employer employer){
        if( employer.getEmail() == null || employer.getEmail().isBlank() || employer.getCompanyName() == null ||
            employer.getCompanyName().isBlank() || employer.getPhoneNumber() == null || employer.getPhoneNumber().isBlank() ||
                employer.getWebAddress() == null || employer.getWebAddress().isBlank()
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
}
