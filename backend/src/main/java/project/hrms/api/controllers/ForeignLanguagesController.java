package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import project.hrms.business.abstracts.ForeignLanguageService;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.entities.concretes.CurriculumVitae;
import project.hrms.entities.concretes.ForeignLanguage;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/foreignLanguages")
public class ForeignLanguagesController {
    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.foreignLanguageService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage){
        var result = this.foreignLanguageService.add(foreignLanguage);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
