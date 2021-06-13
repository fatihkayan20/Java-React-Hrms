package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.City;
import project.hrms.entities.concretes.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {
    DataResult<List<EmploymentType>> getAll();
}
