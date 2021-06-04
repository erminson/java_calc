package service;

import exception.IllegalArgumentCalculatorException;
import exception.ParseCalculatorException;
import exception.TermInitializeCalculatorException;
import model.*;
import util.IParser;
import util.Parser;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Calculator {
    final IParser parser;

    final List<Term> array = new ArrayList<>();
    final Deque<Term> stack = new ArrayDeque<>();

    public Calculator(final IParser parser) {
        this.parser = parser;
    }

    public BigDecimal eval(final String expr) throws ParseCalculatorException, TermInitializeCalculatorException, IllegalArgumentCalculatorException {
        List<Term> expresion = parser.parse(expr);
        getRpnExpression(expresion);

        final Deque<LiteralTerm> calcStack = new ArrayDeque<>();
        for (final Term term: array) {
            if (term.getType() == TermType.Operator) {
                LiteralTerm val2 = calcStack.removeLast();
                LiteralTerm val1 = calcStack.removeLast();
                LiteralTerm result = calc(val1, val2, (OperatorTerm) term);
                calcStack.add(result);
            } else {
                calcStack.add((LiteralTerm)term);
            }
        }

        LiteralTerm result = calcStack.removeLast();

        return result.getValue();
    }

    private void getRpnExpression(final List<Term> expr) {
        for (final Term term : expr) {
            switch (term.getType()) {
                case Bracket: {
                    BracketTerm bracket = (BracketTerm) term;
                    if (bracket.getBracketType() == BracketType.Opening) {
                        stack.add(term);
                    } else {
                        removeTermBeforeOpeningBracket();
                    }
                    break;
                }
                case Literal: {
                    array.add(term);
                    break;
                }
                case Operator: {
                    handleOperator((OperatorTerm) term);
                    break;
                }
            }
        }

        cleanStack();
    }

    private void removeTermBeforeOpeningBracket() {
        for (BracketType bracketType = BracketType.Closing;
             bracketType != BracketType.Opening && !stack.isEmpty(); ) {
            Term term = stack.removeLast();
            if (term.getType() == TermType.Bracket) {
                BracketTerm bracket = (BracketTerm) term;
                bracketType = bracket.getBracketType();
            } else {
                array.add(term);
            }
        }
    }

    private void handleOperator(final OperatorTerm term) {
        Term currentTerm = stack.peekLast();

        if (currentTerm == null || currentTerm.getType() == TermType.Bracket) {
            stack.add(term);
        } else {
            OperatorTerm currentOperator = (OperatorTerm) currentTerm;
            if (currentOperator.getOperatorType().getPriority() < term.getOperatorType().getPriority()) {
                stack.add(term);
            } else {
                stack.removeLast();
                stack.add(term);
                array.add(currentOperator);
            }
        }
    }

    private void cleanStack() {
        while (!stack.isEmpty()) {
            Term term = stack.removeLast();
            array.add(term);
        }
    }

    private LiteralTerm calc(LiteralTerm operand1, LiteralTerm operand2, OperatorTerm op) throws IllegalArgumentCalculatorException {
        BigDecimal val1 = operand1.getValue();
        BigDecimal val2 = operand2.getValue();
        BigDecimal res = BigDecimal.ZERO;

        switch (op.getOperatorType()) {
            case Addition:
                res = val1.add(val2);
                break;
            case Subtraction:
                res = val1.subtract(val2);
                break;
            case Multiplication:
                res = val1.multiply(val2);
                break;
            case Division:
                if (val2.equals(BigDecimal.ZERO)) {
                    throw new IllegalArgumentCalculatorException("Division by zero");
                }
                res = val1.divide(val2);
                break;
        }

        return new LiteralTerm(res);
    }
}
