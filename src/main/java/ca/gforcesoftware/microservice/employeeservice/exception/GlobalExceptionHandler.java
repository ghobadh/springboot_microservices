package ca.gforcesoftware.microservice.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * @author gavinhashemi on 2024-11-18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourcNotFoundExcpetion(ResourceNotFoundException exception,
                                                                       WebRequest webRequest) {
        ErrorDetail errorDetails = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                /* I put the getDescription as false, otherwise it will how the client information like this
                "path": "uri=/api/users/delete/9;client=127.0.0.1",
                 */
                webRequest.getDescription(false),
                "RESOURCE_NOT_FOUND"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
}
