package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.AuthService;
import project.hrms.entities.dtos.RegisterForCandidate;
import project.hrms.entities.dtos.RegisterForEmployer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerForCandidate")
    public ResponseEntity<?> RegisterForCandidate(@RequestBody RegisterForCandidate registerForCandidate){
        var result = authService.candidateRegister(registerForCandidate);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }

    @PostMapping("/registerForEmployer")
    public ResponseEntity<?> RegisterForEmployer(@RequestBody RegisterForEmployer registerForEmployer){
        var result = authService.employerRegister(registerForEmployer);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
