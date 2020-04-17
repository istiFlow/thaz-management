package hu.tarsashazkezelo.tarsashaz.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Missing "+ message);
    }
}
