package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();
    DataResult<CurriculumVitae> add(CurriculumVitae curriculumVitae);
}
