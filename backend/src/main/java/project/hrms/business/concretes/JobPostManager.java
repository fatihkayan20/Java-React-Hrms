package project.hrms.business.concretes;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.JobPostService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.helpers.DynamicFilter;
import project.hrms.core.utilities.helpers.DynamicFilterClass;
import project.hrms.core.utilities.helpers.PredicateType;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.JobPostDao;
import project.hrms.entities.concretes.JobPost;
import project.hrms.entities.filters.JobPostFilter;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class JobPostManager implements JobPostService {
    private final JobPostDao jobPostDao;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao) {
        this.jobPostDao = jobPostDao;
    }

    @Override
    public DataResult<List<JobPost>> getAllActives() {
        List<JobPost> result = this.jobPostDao.getByIsActivatedTrue();
        var jobPosts = result.stream().filter(x -> x.getAppealDeadline() == null || x.getAppealDeadline().isAfter(LocalDate.now().plusDays(1))).collect(Collectors.toList());
        return new SuccessDataResult<>(jobPosts);
    }

    @Override
    public DataResult<List<JobPost>> getAllActivesByDay(int day) {
        List<JobPost> result = this.jobPostDao.getByIsActivatedTrue();
        LocalDate finishDate = LocalDate.now().minusDays(day);
        var jobPosts = result.stream().filter(x -> x.getAppealDeadline() == null || x.getCreatedDate().isAfter(finishDate) || x.getAppealDeadline().isAfter(LocalDate.now().plusDays(1))).collect(Collectors.toList());

        return new SuccessDataResult<>(jobPosts);
    }

    @Override
    public DataResult<List<JobPost>> getAllByEmployer(int employerId) {
        List<JobPost> result = this.jobPostDao.getByIsActivatedTrue();
        var jobPosts = result.stream().filter(x -> x.getEmployer().getId() == employerId || x.getAppealDeadline() == null || x.getAppealDeadline().isAfter(LocalDate.now().plusDays(1))).collect(Collectors.toList());
        return new SuccessDataResult<>(jobPosts);
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


    @Override
    public DataResult<List<JobPost>> getAllActivesWithDynamicFilter(JobPostFilter jobPostFilter) {
        List<JobPost> result = this.jobPostDao.getByIsActivatedTrue();
        var filterText = DynamicFilter.run(filterByEmployer(jobPostFilter));
        var filteredResult = result.stream().filter((Predicate<? super JobPost>) filterText.getData()).collect(Collectors.toList());
        return new SuccessDataResult<>(filteredResult);
    }

    private DataResult filterByEmployer(JobPostFilter jobPostFilter){
        if(jobPostFilter.getEmployer().getId() != 0){
//            DynamicFilterClass dynamicFilterClass = new DynamicFilterClass(x-> x.getEmployer().getId() == jobPostFilter.getEmployer().getId(), PredicateType.AND);
//            return new SuccessDataResult(dynamicFilterClass);
        }
        return null;
    }

}
