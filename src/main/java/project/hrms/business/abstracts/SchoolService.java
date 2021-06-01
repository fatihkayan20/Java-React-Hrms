package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.dataAccess.abstracts.SchoolDao;
import project.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();
    DataResult<School> add(School school);
}
