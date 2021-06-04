package service;

import exception.CalculatorException;
import exception.IllegalArgumentCalculatorException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import util.IParser;
import util.Parser;

import java.math.BigDecimal;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void initCalculator() {
        IParser parser = new Parser();
        calculator = new Calculator(parser);
    }

    @Test
    public void shouldCorrectCalculationSimpleExpression() throws CalculatorException {
        String expr = "3 + 2 * 4 - 1 + 4 / 2";

        BigDecimal expectedResult = new BigDecimal(12);
        BigDecimal actualResult = calculator.eval(expr);

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentCalculatorException.class)
    public void shouldBeThrowIllegalArgumentCalculatorException() throws CalculatorException {
        String expr = "2 + 1 / 0";
        calculator.eval(expr);
    }

    @Test
    public void shouldCorrectCalculationExpressionWithBrackets() throws CalculatorException {
        String expr = "(3 + 2) * 4 - (1 + 4) / 2";

        BigDecimal expectedResult = new BigDecimal(17.5);
        BigDecimal actualResult = this.calculator.eval(expr);

        assertEquals(expectedResult, actualResult);
    }
}
