package exceptions;

public class ItemIdNotFoundException extends RuntimeException  {
    public ItemIdNotFoundException(String message) {
        super(message);
    }
}
