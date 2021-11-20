package exceptions;

public class CustomerIdNotFoundException  extends RuntimeException {
    public CustomerIdNotFoundException(String message) {
        super(message);
    }
}
