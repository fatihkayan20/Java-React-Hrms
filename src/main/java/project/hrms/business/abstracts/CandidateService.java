package project.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.User;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> get(int id);
    DataResult<Candidate> add(Candidate candidate);
    DataResult<Candidate> imageUpload(int candidateId, MultipartFile file) throws IOException;
    Result delete(Candidate candidate);
    DataResult<Candidate> update(Candidate candidate);
}
