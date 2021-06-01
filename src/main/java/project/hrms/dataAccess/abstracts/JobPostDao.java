package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.JobPost;

import java.time.LocalDate;
import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost,Integer> {
    List<JobPost> getByIsActivatedTrueAndAppealDeadlineNullOrAppealDeadlineGreaterThanEqual(LocalDate date);
    List<JobPost> getByCreatedDateBetweenAndIsActivatedTrueOrderByCreatedDateDesc(LocalDate startDate, LocalDate finishDate);
    List<JobPost> getByEmployer_IdAndIsActivatedTrueAndAppealDeadlineNullOrAppealDeadlineGreaterThanEqual(int employerId, LocalDate date);

    JobPost getById(int id);
}
