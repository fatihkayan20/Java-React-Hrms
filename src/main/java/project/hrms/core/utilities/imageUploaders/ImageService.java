package project.hrms.core.utilities.imageUploaders;

import org.springframework.web.multipart.MultipartFile;
import project.hrms.core.utilities.results.DataResult;

import java.util.Map;

public interface ImageService {
    DataResult<Map> save(MultipartFile file);
}
