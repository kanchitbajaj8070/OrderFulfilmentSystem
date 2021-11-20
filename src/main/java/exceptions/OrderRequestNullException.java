package exceptions;

public class OrderRequestNullException extends RuntimeException {
    public OrderRequestNullException(String message) {
        super(message);
    }
}
