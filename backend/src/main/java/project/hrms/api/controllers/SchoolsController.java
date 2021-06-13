package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.SchoolService;
import project.hrms.entities.concretes.School;
@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.schoolService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody School school){
        var result = this.schoolService.add(school);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
