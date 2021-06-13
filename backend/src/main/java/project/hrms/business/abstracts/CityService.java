package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
}
