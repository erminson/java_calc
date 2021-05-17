package view;

import util.IValidator;
import util.Validator;

import java.math.BigDecimal;
import java.util.Scanner;

public class TerminalView implements IView {
    private final IValidator validator;

    public TerminalView(final IValidator validator) {
        this.validator = validator;
    }

    @Override
    public String readExpression() {
        String expr;
        do {
            System.out.println("Enter expression: ");
            expr = new Scanner(System.in).nextLine();

            if (validator.isValid(expr)) {
                break;
            } else {
                System.out.println("Expression is not valid.");
            }
        } while (true);

        return expr;
    }

    @Override
    public void printResult(BigDecimal result) {
        System.out.println("Result: " + String.format("%.2f", result));
    }
}
