package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.EmploymentTypeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.EmploymentTypeDao;
import project.hrms.entities.concretes.EmploymentType;

import java.util.List;

@Service
public class EmploymentTypeManager  implements EmploymentTypeService {
    private EmploymentTypeDao employmentTypeDao;
@Autowired
    public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
        this.employmentTypeDao = employmentTypeDao;
    }


    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<>(this.employmentTypeDao.findAll());
    }
}
