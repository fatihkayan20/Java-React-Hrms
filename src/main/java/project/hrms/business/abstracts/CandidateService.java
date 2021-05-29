package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

import javax.xml.crypto.Data;
import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> get(int id);
    Result add(Candidate candidate);
    Result delete(Candidate candidate);
    Result update(Candidate candidate);
}
