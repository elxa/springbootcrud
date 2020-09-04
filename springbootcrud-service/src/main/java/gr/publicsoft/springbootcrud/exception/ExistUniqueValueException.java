package gr.publicsoft.springbootcrud.exception;

public class ExistUniqueValueException extends BusinessException {
    public ExistUniqueValueException(String message) {
        super(message);
    }
}
