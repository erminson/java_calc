import exception.ParseCalculatorException;
import exception.TermInitializeCalculatorException;
import service.Calculator;
import util.IParser;
import util.IValidator;
import util.Parser;
import util.Validator;
import view.IView;
import view.TerminalView;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        final IValidator validator = new Validator();
        final IView terminalView = new TerminalView(validator);

        final IParser parser = new Parser();
        final Calculator calc = new Calculator(parser);

        String expr = terminalView.readExpression();

        try {
            BigDecimal value = calc.eval(expr);
            terminalView.printResult(value);
        } catch (ParseCalculatorException | TermInitializeCalculatorException e) {
            e.printStackTrace();
        }
    }
}
