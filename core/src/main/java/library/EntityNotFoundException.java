package library;

public class EntityNotFoundException extends Exception {
    public String exMessage;
    public EntityNotFoundException(String exMessage){
        this.exMessage=exMessage;
    }
}
