package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobPostService;
import project.hrms.entities.concretes.JobPost;
@CrossOrigin
@RestController
@RequestMapping("/api/jobpostings/")
public class JobPostController {
    private final JobPostService jobPostService;

    @Autowired
    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("getactives")
    public ResponseEntity<?> getAllActives(){
        var result = this.jobPostService.getAllActives();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getbyday")
    public ResponseEntity<?> getAllActivesByDay(@RequestParam int day){
        var result = this.jobPostService.getAllActivesByDay(day);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getbyemployer")
    public ResponseEntity<?> getAllByEmployer(@RequestParam int employerId){
        var result = this.jobPostService.getAllByEmployer(employerId);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("toggleactive")
    public ResponseEntity<?> toggleActive(@RequestParam int postId){
        var result = this.jobPostService.toggleActive(postId);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobPost jobPost){
        var result = this.jobPostService.add(jobPost);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
