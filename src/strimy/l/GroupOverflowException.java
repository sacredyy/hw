package strimy.l;

public class GroupOverflowException extends Exception{
    public GroupOverflowException(Throwable cause) {
        super(cause);
    }

    public GroupOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupOverflowException(String message) {
        super(message);
    }

    public GroupOverflowException() {
        super();
    }
}
