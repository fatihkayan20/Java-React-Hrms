package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.helpers.BusinessRule;
import project.hrms.core.utilities.imageUploaders.ImageService;
import project.hrms.core.utilities.results.*;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.entities.concretes.Candidate;

import java.io.IOException;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final UserService userService;
    private final ImageService imageService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService,ImageService imageService) {
        this.candidateDao = candidateDao;
        this.userService= userService;
        this.imageService = imageService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> get(int id) {
        return new SuccessDataResult<>(candidateDao.findById(id).get());
    }

    @Override
    public DataResult<Candidate> add(Candidate candidate) {
        var isValid = BusinessRule.run(
                checkIfCandidateValid(candidate), checkIfEmailExists(candidate.getEmail()),checkIfNationalIdentityExists(candidate.getNationalIdentity())
        );

        if (!isValid.isSuccess()){
            return new ErrorDataResult<>(null, isValid.getMessage());
        }


        return new SuccessDataResult<>( this.candidateDao.save(candidate),"Added.");
    }

    @Override
    public DataResult<Candidate> imageUpload(int candidateId, MultipartFile file) throws IOException {
        var candidate = this.candidateDao.getById(candidateId);
        if(candidate == null){
            return new ErrorDataResult<>(null, "Candidate doesn't exists");
        }
        var imageUrl = uploadImageToCloudinary(file, candidate.getImageUrl());
        var result = BusinessRule.run(checkCandidateExists(candidate), checkCandidateHadImageUrl(imageUrl.getMessage(),candidate.getImageUrl()));

        if (!result.isSuccess() ||!imageUrl.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage() == null ? imageUrl.getMessage(): result.getMessage());
        }
        candidate.setImageUrl(imageUrl.getMessage());
        return new SuccessDataResult<>(this.candidateDao.save(candidate));
    }

    @Override
    public Result delete(Candidate candidate) {
        candidateDao.delete(candidate);
        return new SuccesResult("Deleted.");
    }

    @Override
    public DataResult<Candidate> update(Candidate candidate) {

        return new SuccessDataResult<>(this.candidateDao.save(candidate),"Updated.");
    }




    private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {
        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccesResult(url.toString());

    }

    private Result checkCandidateHadImageUrl(String newUrl, String oldUrl){
        if(oldUrl != null && newUrl == null){
            return new ErrorResult("Image must be required");
        }
        return new SuccesResult();
    }

    private Result checkCandidateExists(Candidate candidate){
        if (candidate == null){
            return new ErrorResult("Candidate doesn't exists");
        }
        return  new SuccesResult();
    }

    private Result checkIfCandidateValid(Candidate candidate){
        if(candidate.getFirstName() == null || candidate.getFirstName().isBlank()
            || candidate.getLastName() == null || candidate.getLastName().isBlank() ||
                candidate.getNationalIdentity() == null ||candidate.getNationalIdentity().isBlank() ||
                candidate.getDateOfBirth() == null || candidate.getEmail() ==null ||candidate.getEmail().isBlank() ||
                candidate.getPassword() == null ||candidate.getPassword().isBlank()
        ){
            return new ErrorResult("All fields are required");
        }
        return new SuccesResult();
    }

    private Result checkIfEmailExists(String email){
        var user = this.userService.getByEmail(email);
        if(user != null){
            return new ErrorResult("Email is already exists");
        }
        return new SuccesResult();
    }

    private Result checkIfNationalIdentityExists(String nationalIdentity){
        var user = this.candidateDao.getByNationalIdentity(nationalIdentity);
        if(user != null){
            return new ErrorResult("National identity is already exists");
        }
        return new SuccesResult();
    }
}
