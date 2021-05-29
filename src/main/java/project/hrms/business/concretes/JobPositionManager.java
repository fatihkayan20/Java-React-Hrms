package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobPositionDao;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll());
    }

    @Override
    public DataResult<JobPosition> get(int id) {
        return new SuccessDataResult<>(jobPositionDao.findById(id).get());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRule.run(checkIfTitleExists(jobPosition.getTitle()));
        if(!result.isSuccess()){
            return result;
        }
        jobPositionDao.save(jobPosition);
        return new SuccesResult("Added.");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return new SuccesResult("Deleted.");
    }

    @Override
    public Result update(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccesResult("Updated.");
    }

    private Result checkIfTitleExists(String title){
        var position = this.jobPositionDao.getByTitleContainingIgnoreCase(title);
        if(position != null){
            return new ErrorResult("Title is already exists");
        }
        return new SuccesResult();
    }
}
