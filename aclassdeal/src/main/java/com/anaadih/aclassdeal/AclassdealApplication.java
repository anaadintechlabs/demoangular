package com.anaadih.aclassdeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.anaadih.aclassdeal.property.FileUploadProperties;



@SpringBootApplication
@EnableConfigurationProperties({
	FileUploadProperties.class
})
public class AclassdealApplication {

	public static void main(String[] args) {
		SpringApplication.run(AclassdealApplication.class, args);
	}

}
