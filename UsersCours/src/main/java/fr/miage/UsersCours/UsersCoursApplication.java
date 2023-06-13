package fr.miage.UsersCours;

import fr.miage.UsersCours.repository.UserWithClassRepository;
import fr.miage.UsersCours.repository.UserWithClassRepositoryImpl;
import fr.miage.UsersCours.transientobj.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UsersCoursApplication {

	public static final String USER_SERVICE_URL = "http://user-service:10000";

	public static void main(String[] args) {
		SpringApplication.run(UsersCoursApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public UserWithClassRepository userWithClassRepository() {
		return new UserWithClassRepositoryImpl(USER_SERVICE_URL);
	}
}
