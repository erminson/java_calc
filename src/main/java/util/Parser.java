package util;

import exception.ParseCalculatorException;
import exception.TermInitializeCalculatorException;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements IParser {
    @Override
    public List<Term> parse(final String expr) throws ParseCalculatorException, TermInitializeCalculatorException {
        final String exprWithoutSpaces = clean(expr);
        final List<String> rawParts = splitExpressionToParts(exprWithoutSpaces);
        final List<Term> parts = getExpression(rawParts);
        return parts;
    }

    private String clean(final String expr) {
        return expr.replaceAll(" ", "").trim();
    }

    private List<String> splitExpressionToParts(final String expr) {
        final List<String> parts = new ArrayList<>();

        char[] chars = expr.toCharArray();
        int size = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Character ch = chars[i];
            if (isDigitPart(ch)) {
                sb.append(ch);
                if (i == size - 1) {
                    parts.add(sb.toString());
                }
            } else {
                if (sb.length() != 0) {
                    parts.add(sb.toString());
                }
                parts.add(ch.toString());
                sb = new StringBuilder();
            }
        }

        return parts;
    }

    private boolean isBracket(final String sign) {
        final Pattern pattern = Pattern.compile("\\(|\\)");
        final Matcher matcher = pattern.matcher(sign);
        return matcher.matches();
    }

    private boolean isDigitPart(final Character ch) {
        final Pattern pattern = Pattern.compile("([0-9]|\\.)");
        final Matcher matcher = pattern.matcher(ch.toString());
        return matcher.matches();
    }

    private boolean isDigitTerm(final String termString) {
        final Pattern pattern = Pattern.compile("^(-?)(0|([1-9][0-9]*))?\\.?([0-9]+)$");
        final Matcher matcher = pattern.matcher(termString);
        return matcher.matches();
    }

    private List<Term> getExpression(List<String> exp) throws ParseCalculatorException, TermInitializeCalculatorException {
        List<Term> expression = new ArrayList<>();
        for (final String termString : exp) {
            if (isDigitTerm(termString)) {
                final LiteralTerm literal = new LiteralTerm(new BigDecimal(termString));
                expression.add(literal);
            } else if (isBracket(termString)) {
                final BracketTerm bracket = new BracketTerm(termString);
                expression.add(bracket);
            } else {
                OperatorType type = operatorTypeByString(termString);
                final OperatorTerm operator = new OperatorTerm(type);
                expression.add(operator);
            }
        }

        return expression;
    }

    private OperatorType operatorTypeByString(String op) throws ParseCalculatorException {
        OperatorType ot;
        switch (op) {
            case "+": {
                ot = OperatorType.Addition;
                break;
            }
            case "-": {
                ot = OperatorType.Subtraction;
                break;
            }
            case "*": {
                ot = OperatorType.Multiplication;
                break;
            }
            case "/": {
                ot = OperatorType.Division;
                break;
            }
            default: {
                throw new ParseCalculatorException("Parser. Incorrect mathematical operation: " + op);
            }
        }

        return ot;
    }
}
