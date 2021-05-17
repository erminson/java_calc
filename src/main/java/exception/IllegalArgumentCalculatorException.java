package exception;

public class IllegalArgumentCalculatorException extends CalculatorException {
    public IllegalArgumentCalculatorException() {
        super();
    }

    public IllegalArgumentCalculatorException(String message) {
        super(message);
    }

    public IllegalArgumentCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalArgumentCalculatorException(Throwable cause) {
        super(cause);
    }
}
