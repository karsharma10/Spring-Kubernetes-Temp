package learnk8s.io.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "knote")
public class KnoteProperties {

    @Value("${uploadDir:/tmp/uploads/}")
    private String uploadDir;

    public String getUploadDir(){
        return uploadDir;
    }
}
