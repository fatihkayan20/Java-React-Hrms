package project.hrms;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import project.hrms.core.utilities.imageUploaders.CloudinaryManager;
import project.hrms.core.utilities.imageUploaders.ImageService;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ImageService imageService(){
        return new CloudinaryManager();
    }

}
