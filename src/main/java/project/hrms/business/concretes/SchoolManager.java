package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.SchoolDao;
import project.hrms.entities.concretes.School;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"finishDate");
        return new SuccessDataResult<>(this.schoolDao.findAll(sort));
    }

    @Override
    public DataResult<School> add(School school) {
        return new SuccessDataResult<>(this.schoolDao.save(school));
    }
}
