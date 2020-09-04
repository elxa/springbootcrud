package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.dto.ErrorDetails;
import gr.publicsoft.springbootcrud.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorController {

    /**
     *
     * @param ex
     * @param request
     * @return a json file with the message
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleResourseJobOfferNotFoundExcheption(BusinessException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage() ,request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Check the annotation in the entity class and return a error if the data isn't valid
     *
     * @param ex
     * @param request
     * @return a json error if data isn't valid
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> personValidationNotFoundExcheption(MethodArgumentNotValidException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, "Validation Error" , ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
