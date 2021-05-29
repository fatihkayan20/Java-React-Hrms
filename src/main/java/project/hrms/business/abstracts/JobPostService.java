package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobPost;

import java.time.LocalDate;
import java.util.List;

public interface JobPostService {
    DataResult<List<JobPost>> getAllActives();
    DataResult<List<JobPost>> getAllActivesByDay(int day);
    DataResult<List<JobPost>> getAllByEmployer(int employerId);


    Result add(JobPost jobPost);
    Result toggleActive(int postId);


}
