package fr.miage.UsersCours;

import fr.miage.UsersCours.repository.ClassDetailsRepository;
import fr.miage.UsersCours.repository.ClassDetailsRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersCoursApplication {

	public static final String USER_SERVICE_URL = "http://USERS-SERVICE";

	public static final String CLASS_SERVICE_URL = "http://CLASSES-SERVICE";

	public static void main(String[] args) {
		SpringApplication.run(UsersCoursApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ClassDetailsRepository userWithClassRepository() {
		return new ClassDetailsRepositoryImpl(USER_SERVICE_URL, CLASS_SERVICE_URL);
	}
}
