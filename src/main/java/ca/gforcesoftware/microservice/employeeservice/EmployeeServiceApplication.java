package ca.gforcesoftware.microservice.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

// I commented in to use WebClient instead
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

// I commented in to use Spring Cloud Open Feign instead
//    @Bean
//    public WebClient webClient() {
//        return WebClient.builder().build();
//    }
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
