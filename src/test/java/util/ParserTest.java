package util;

import exception.ParseCalculatorException;
import exception.TermInitializeCalculatorException;
import model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ParserTest {
    private static Parser parser;

    @BeforeClass
    public static void initParser() {
        parser = new Parser();
    }

    @Test
    public void shouldBeTrueWhenSimpleExpression() throws TermInitializeCalculatorException, ParseCalculatorException {
        List<Term> expectedList = Stream.of(
                new LiteralTerm(new BigDecimal(3)),
                new OperatorTerm(OperatorType.Addition),
                new LiteralTerm(new BigDecimal(2)),
                new OperatorTerm(OperatorType.Multiplication),
                new LiteralTerm(new BigDecimal(4)),
                new OperatorTerm(OperatorType.Subtraction),
                new LiteralTerm(new BigDecimal(1)),
                new OperatorTerm(OperatorType.Addition),
                new LiteralTerm(new BigDecimal(4)),
                new OperatorTerm(OperatorType.Division),
                new LiteralTerm(new BigDecimal(2))
        ).collect(Collectors.toList());

        String expr = "3 + 2 * 4 - 1 + 4 / 2";
        List<Term> actualList = parser.parse(expr);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void shouldBeTrueWhenExpressionWithBrackets() throws TermInitializeCalculatorException, ParseCalculatorException {
        List<Term> expectedList = Stream.of(
                new BracketTerm(BracketType.Opening),
                new LiteralTerm(new BigDecimal(3)),
                new OperatorTerm(OperatorType.Addition),
                new LiteralTerm(new BigDecimal(2)),
                new BracketTerm(BracketType.Closing),
                new OperatorTerm(OperatorType.Multiplication),
                new LiteralTerm(new BigDecimal(4)),
                new OperatorTerm(OperatorType.Subtraction),
                new BracketTerm(BracketType.Opening),
                new LiteralTerm(new BigDecimal(1)),
                new OperatorTerm(OperatorType.Addition),
                new LiteralTerm(new BigDecimal(4)),
                new BracketTerm(BracketType.Closing),
                new OperatorTerm(OperatorType.Division),
                new LiteralTerm(new BigDecimal(2))
        ).collect(Collectors.toList());

        String expr = "(3 + 2) * 4 - (1 + 4) / 2";
        List<Term> actualList = parser.parse(expr);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test(expected = ParseCalculatorException.class)
    public void shouldBeThrowParseCalculatorException() throws TermInitializeCalculatorException, ParseCalculatorException {
        String expr = "(3 + 2) * 4 - (1 + 4) / 2o";
        List<Term> actualList = parser.parse(expr);
    }
}
