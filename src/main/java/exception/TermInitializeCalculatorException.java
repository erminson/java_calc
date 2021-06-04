package exception;

public class TermInitializeCalculatorException extends CalculatorException {
    public TermInitializeCalculatorException() {
        super();
    }

    public TermInitializeCalculatorException(String message) {
        super(message);
    }

    public TermInitializeCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TermInitializeCalculatorException(Throwable cause) {
        super(cause);
    }
}
