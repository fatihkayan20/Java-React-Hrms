package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperianceService {
    DataResult<List<JobExperience>> getAll();

    DataResult<JobExperience> add(JobExperience jobExperience);
}
