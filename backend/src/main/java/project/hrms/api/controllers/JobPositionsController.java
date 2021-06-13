package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.JobPositionService;
import project.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        var result = jobPositionService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @GetMapping("get")
    public  ResponseEntity<?> get(int id){
        var result = jobPositionService.get(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping ("add")
    public ResponseEntity<?> add(@RequestBody JobPosition jobPosition){
        var result = jobPositionService.add(jobPosition);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody JobPosition jobPosition){
        var result =  jobPositionService.delete(jobPosition);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody JobPosition jobPosition){
        var result = jobPositionService.update(jobPosition);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

}
