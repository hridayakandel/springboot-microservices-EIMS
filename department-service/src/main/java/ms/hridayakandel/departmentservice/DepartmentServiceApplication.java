package ms.hridayakandel.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs Documentation",
				description = "Department service REST APIs Documentation",
				version = "v1.0",
				contact=@Contact(
						name = "Hridaya",
						email = "hridayakandel@gmail.com"
				),
				license = @License(
						name="Apache 2.0",
						url= "https://www.hridayakandel.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-service docs",
				url = "https://www.hridayakandel.com"
		)

)
@SpringBootApplication
//@EnableEurekaClient
public class DepartmentServiceApplication {
	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(DepartmentServiceApplication.class, args);

	}

}
