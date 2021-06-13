package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience , Integer> {
}
