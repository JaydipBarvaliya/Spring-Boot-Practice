//package com.example.demo.Controllers;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.StreamSupport;
//
//import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;
//
//@ControllerAdvice
//@RestController
//public class ExceptionController {
//	
//	
//	
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public List<ValidationErrors> handleConstraintViolation(ConstraintViolationException ex) {
//            
//        return buildValidationErrors(ex.getConstraintViolations());
//    }
//    
//    private List<ValidationErrors>  buildValidationErrors(Set<ConstraintViolation<?>> violations) {
//    	
//    	
//        return (List<ValidationErrors>) violations
//        		.stream().
//               map(violation -> 
//               ValidationError.builder().
//               field(
//                  StreamSupport.stream(
//                  violation.getPropertyPath().spliterator(), false).
//                  reduce((first, second) -> second).
//                  orElse(null).
//                  toString()
//               ).
//               error(violation.getMessage()).
//               build());
////               .collect(toList());
//      }
//   }
