package project.hrms.core.utilities.imageUploaders;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
    DataResult<Map> delete (String id) throws IOException;
}
