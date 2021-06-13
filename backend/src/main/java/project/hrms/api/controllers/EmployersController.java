package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.entities.concretes.Employer;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

    private EmployerService employerService;


    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        var result = employerService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @GetMapping("get")
    public ResponseEntity<?> get(int id){
        var result = employerService.get(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Employer employer){
        var result = employerService.add(employer);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping("delete")
    public ResponseEntity<?> delete(@RequestBody Employer employer){

        var result = employerService.delete(employer);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }


    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody Employer employer){

        var result = employerService.update(employer);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
