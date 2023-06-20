package fr.miage.classService;

import fr.miage.classService.repositories.UserRepository;
import fr.miage.classService.repositories.UserRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ClassServiceApplication {

	public static final String USER_SERVICE_URL = "http://USERS-SERVICE";

	public static void main(String[] args) {
		SpringApplication.run(ClassServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public UserRepository userRepositoryImpl() {
		return new UserRepositoryImpl(USER_SERVICE_URL);
	}
}
