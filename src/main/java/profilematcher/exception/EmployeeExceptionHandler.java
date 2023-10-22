package profilematcher.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  private ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("message", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
