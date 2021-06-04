package view;

import util.IValidator;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class TerminalView implements IView {
    private final IValidator validator;

    public TerminalView(final IValidator validator) {
        this.validator = validator;
    }

    @Override
    public String readExpression() {
        return readExpression(new Scanner(System.in), System.out);
    }

    public String readExpression(Scanner scanner) {
        return readExpression(scanner, System.out);
    }

    public String readExpression(Scanner scanner, PrintStream output) {
        String expr;
        do {
            output.println("Enter expression: ");
            expr = scanner.nextLine();

            if (validator.isValid(expr)) {
                break;
            } else {
                output.println("Expression is not valid.");
            }
        } while (true);

        return expr;
    }

    @Override
    public void printResult(BigDecimal result) {
        System.out.println("Result: " + String.format("%.2f", result));
    }
}
