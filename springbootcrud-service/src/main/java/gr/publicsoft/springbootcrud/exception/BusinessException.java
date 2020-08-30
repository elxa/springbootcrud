package gr.publicsoft.springbootcrud.exception;

public class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
}
