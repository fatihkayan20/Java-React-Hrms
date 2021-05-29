package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.JobPost;

import java.time.LocalDate;
import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost,Integer> {
    List<JobPost> getByIsActivatedTrueOrderByCreatedDateDesc();
    List<JobPost> getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(LocalDate startDate, LocalDate finishDate);
    List<JobPost> getByEmployer_IdAndIsActivatedTrue(int employerId);
    JobPost getById(int id);
}
