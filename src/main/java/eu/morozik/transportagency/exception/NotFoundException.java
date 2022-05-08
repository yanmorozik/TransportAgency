package eu.morozik.transportagency.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super("entity with id: " + id + " was not found");
    }
}
