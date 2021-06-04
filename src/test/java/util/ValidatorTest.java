package util;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidatorTest {

    private static Validator validator;

    @BeforeClass
    public static void initValidator() {
        validator = new Validator();
    }

    @Test
    public void shouldBeTrueWhenSimpleExpression() {
        String expr = "3 + 2 * 4 - 1 + 4 / 2";
        assertTrue(validator.isValid(expr));
    }

    @Test
    public void shouldBeTrueWhenExpressionWithBrackets() {
        String expr = "(3 + 2) * 4 - (1 + 4) / 2";
        assertTrue(validator.isValid(expr));
    }

    @Test
    public void shouldBeFalseWhenNotCorrectExpression() {
        String expr = "(3 + 2) * 4 - (1 + 4) / 2o";
        assertFalse(validator.isValid(expr));
    }
}
