package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.EmploymentTypeService;

@CrossOrigin
@RestController
@RequestMapping("/api/employmenttypes")
public class EmploymentTypesController {
    private EmploymentTypeService employmentTypeService;
@Autowired
    public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        var result = this.employmentTypeService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
