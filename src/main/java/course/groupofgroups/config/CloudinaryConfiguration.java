package course.groupofgroups.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class CloudinaryConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name = "com.cloudinary.cloud_name")
    public String getCloudinaryCloudName() {
        return environment.getProperty("com.cloudinary.cloud_name");
    }

    @Bean(name = "com.cloudinary.api_key")
    public String getCloudinaryApiKey() {
        return environment.getProperty("com.cloudinary.api_key");
    }

    @Bean(name = "com.cloudinary.api_secret")
    public String getCloudinaryApiSecret() {
        return environment.getProperty("com.cloudinary.api_secret");
    }

    @Bean
    public Cloudinary getCloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", getCloudinaryCloudName(),
                "api_key", getCloudinaryApiKey(),
                "api_secret", getCloudinaryApiSecret(),
                "secure", true
        ));
        return cloudinary;
    }
}
