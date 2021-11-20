package exceptions;

public class CategoryIdNotFoundException extends RuntimeException  {
    public CategoryIdNotFoundException(String message) {
        super(message);
    }
}
