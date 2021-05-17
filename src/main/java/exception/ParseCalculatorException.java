package exception;

public class ParseCalculatorException extends CalculatorException {
    public ParseCalculatorException() {
        super();
    }

    public ParseCalculatorException(String message) {
        super(message);
    }

    public ParseCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseCalculatorException(Throwable cause) {
        super(cause);
    }
}
