package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    DataResult<List<ForeignLanguage>> getAll();
    DataResult<ForeignLanguage> add(ForeignLanguage foreignLanguage);
}
