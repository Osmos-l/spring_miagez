package fr.miage.UsersCours;

import fr.miage.UsersCours.repository.UserWithClassRepository;
import fr.miage.UsersCours.repository.UserWithClassRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersCoursApplication {

	public static final String USER_SERVICE_URL = "http://USERS-SERVICE";

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
