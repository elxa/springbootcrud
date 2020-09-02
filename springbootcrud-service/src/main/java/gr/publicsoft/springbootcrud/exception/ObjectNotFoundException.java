package gr.publicsoft.springbootcrud.exception;

public class ObjectNotFoundException extends BusinessException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}