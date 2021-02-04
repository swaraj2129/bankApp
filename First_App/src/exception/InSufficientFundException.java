package exception;

public class InSufficientFundException extends RuntimeException {

    private String message;

    public InSufficientFundException(String message) {
    super(message);
    }




}