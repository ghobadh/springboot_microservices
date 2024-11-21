package ca.gforcesoftware.microservice.depratmentservice.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gavinhashemi on 2024-11-21
 */
@RestController
@RefreshScope  // This annotation push the spring to load this class file
public class MessageController {

    @Value("${Spring.boot.message}")
    private String message;


    @GetMapping("message")
    public String message() {
        return message;
    }
}
