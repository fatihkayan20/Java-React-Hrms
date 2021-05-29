package project.hrms.business.concretes;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPostService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobPostDao;
import project.hrms.entities.concretes.JobPost;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostManager implements JobPostService {
    private final JobPostDao jobPostDao;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao) {
        this.jobPostDao = jobPostDao;
    }

    @Override
    public DataResult<List<JobPost>> getAllActives() {
        return new SuccessDataResult<>(this.jobPostDao.getByIsActivatedTrueOrderByCreatedDateDesc());
    }

    @Override
    public DataResult<List<JobPost>> getAllActivesByDay(int day) {
        LocalDate finishDate = LocalDate.now().minusDays(day);
        return new SuccessDataResult<>(this.jobPostDao.getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(finishDate,LocalDate.now()));
    }

    @Override
    public DataResult<List<JobPost>> getAllByEmployer(int employerId) {
        return new SuccessDataResult<>(this.jobPostDao.getByEmployer_IdAndIsActivatedTrue(employerId));
    }

    @Override
    public Result add(JobPost jobPost) {
        this.jobPostDao.save(jobPost);
        return new SuccesResult("Added.");
    }

    @Override
    public Result toggleActive(int postId) {
        var jobPost = this.jobPostDao.getById(postId);
        var result = BusinessRule.run(checkJobPostIsExists(jobPost));
        if (!result.isSuccess()){
            return result;
        }

        JobPost updatePost = jobPost;
        updatePost.setActivated(!updatePost.isActivated());
        this.jobPostDao.save(updatePost);
        return new SuccesResult("Update Successfully");
    }


    private Result checkJobPostIsExists(JobPost jobPost){
        if (jobPost == null){
            return new ErrorResult("Job post doesn't exists");
        }
        return new SuccesResult();
    }
}
