package project.hrms.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

import java.io.IOException;
import java.util.Map;

public class CloudinaryManager implements ImageService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public DataResult<Map> save(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());

            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            return new ErrorDataResult<Map>();
        }

    }
}
