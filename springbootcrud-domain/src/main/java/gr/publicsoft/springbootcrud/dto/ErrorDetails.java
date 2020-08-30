package gr.publicsoft.springbootcrud.dto;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private HttpStatus statusCode;
    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(HttpStatus statusCode, String message, String details) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
