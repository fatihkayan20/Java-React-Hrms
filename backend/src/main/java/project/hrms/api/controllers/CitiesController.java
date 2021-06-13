package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.CityService;

@CrossOrigin
@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        var result = this.cityService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
