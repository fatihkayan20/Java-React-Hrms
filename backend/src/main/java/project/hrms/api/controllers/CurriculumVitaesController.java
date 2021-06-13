package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/cvs")
public class CurriculumVitaesController {
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.curriculumVitaeService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbycandidate")
    public ResponseEntity<?> getByCandidate(int id){
        var result = this.curriculumVitaeService.getByCandidate(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae){
        var result = this.curriculumVitaeService.add(curriculumVitae);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
