package project.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobExperianceService;
import project.hrms.entities.concretes.ForeignLanguage;
import project.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiances")
public class JobExperiancesController {
    private JobExperianceService jobExperianceService;

    @Autowired
    public JobExperiancesController(JobExperianceService jobExperianceService) {
        this.jobExperianceService = jobExperianceService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.jobExperianceService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobExperience jobExperience){
        var result = this.jobExperianceService.add(jobExperience);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
