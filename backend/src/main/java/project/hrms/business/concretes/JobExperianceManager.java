package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobExperianceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.JobExperienceDao;
import project.hrms.entities.concretes.JobExperience;

import java.util.List;

@Service
public class JobExperianceManager implements JobExperianceService {
    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperianceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
    }

    @Override
    public DataResult<JobExperience> add(JobExperience jobExperience) {
        return new SuccessDataResult<>(this.jobExperienceDao.save(jobExperience));
    }
}
