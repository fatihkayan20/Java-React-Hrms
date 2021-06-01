package project.hrms.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageService {

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryManager() {
        valuesMap.put("cloud_name","duwxmiutg" );
        valuesMap.put("api_key", "857119181139787" );
        valuesMap.put("api_secret","sOq5jj2sKz3ZQhJWaZb_Ld-SFU0" );
        cloudinary = new Cloudinary(valuesMap);
    }

    public DataResult<Map> upload (MultipartFile multipartFile) throws IOException {
        Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convert(multipartFile);
        Map result= null;
        try {
             result = cloudinary.uploader().upload(file, options);
        }catch (Exception e){
            return new ErrorDataResult<>(e.getMessage());
        }
        file.delete();
        return new SuccessDataResult<>(result);
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map<String , Boolean> options = new HashMap<>();
        options.put("invalidate",true);
        Map result = cloudinary.uploader().destroy(id,options);
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}