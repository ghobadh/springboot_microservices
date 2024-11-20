package ca.gforcesoftware.microservice.depratmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class DepratmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepratmentServiceApplication.class, args);
    }

}
