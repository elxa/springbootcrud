package gr.publicsoft.springbootcrud.exception;

public class SupplierNotFoundException extends BusinessException {
    public SupplierNotFoundException(String message) {
        super(message);
    }
}