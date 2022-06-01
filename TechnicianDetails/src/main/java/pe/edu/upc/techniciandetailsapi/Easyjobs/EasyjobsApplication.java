package pe.edu.upc.techniciandetailsapi.Easyjobs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EasyjobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyjobsApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
