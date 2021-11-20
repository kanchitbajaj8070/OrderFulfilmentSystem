package exceptions;

public class WarehouseIdNotFoundException extends RuntimeException  {
    public WarehouseIdNotFoundException(String message) {
        super(message);
    }
}
