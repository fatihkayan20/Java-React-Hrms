package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates/")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        var result = this.candidateService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

    @GetMapping("get")
    public ResponseEntity<?> get(int id){

        var result = this.candidateService.get(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Candidate candidate){

        var result = this.candidateService.add(candidate);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

    @PostMapping("uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam int candidateId, @RequestParam MultipartFile file){
        var result = this.candidateService.imageUpload(candidateId,file);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

    @PostMapping("delete")
    public ResponseEntity<?> delete(Candidate candidate){


        var result = this.candidateService.delete(candidate);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);

    }

    @PostMapping("update")
    public ResponseEntity<?> update(Candidate candidate){
        var result = this.candidateService.update(candidate);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
