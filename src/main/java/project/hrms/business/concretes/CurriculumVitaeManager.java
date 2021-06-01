package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import project.hrms.entities.concretes.CurriculumVitae;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {
    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll());
    }

    @Override
    public DataResult<List<CurriculumVitae>> getByCandidate(int id) {
        return new SuccessDataResult<>(this.curriculumVitaeDao.getByCandidate_Id(id));
    }

    @Override
    public DataResult<CurriculumVitae> add(CurriculumVitae curriculumVitae) {
        return new SuccessDataResult<>(this.curriculumVitaeDao.save(curriculumVitae));
    }
}
