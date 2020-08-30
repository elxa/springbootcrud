package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.dto.ErrorDetails;
import gr.publicsoft.springbootcrud.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleResourseJobOfferNotFoundExcheption(BusinessException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage() ,request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
