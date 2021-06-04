package model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LiteralTermTest {
    private static LiteralTerm literalTerm1;
    private static LiteralTerm literalTerm2;

    @BeforeClass
    public static void initLiterals() {
        literalTerm1 = new LiteralTerm(new BigDecimal(1));
        literalTerm2 = new LiteralTerm(new BigDecimal(1));
    }

    @Test
    public void valueLiteralShouldBeEqualOne() {
        BigDecimal expectedValue = new BigDecimal(1);
        BigDecimal actualValue = literalTerm1.getValue();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void typeTermLiteralShouldBeEqualLiteral() {
        TermType expectedType = TermType.Literal;
        TermType actualType = literalTerm1.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    public void twoSameLiteralShouldBeEqual() {
        assertEquals(literalTerm1, literalTerm2);
    }

    @Test
    public void twoSameLiteralShouldBeReturnEqualValues() {
        assertEquals(literalTerm1.getValue(), literalTerm2.getValue());
    }

    @Test
    public void twoSameLiteralsShouldEqualToString() {
        assertEquals(literalTerm1.toString(), literalTerm2.toString());
    }

    @Test
    public void twoSameLiteralsShouldEqualHashCode() {
        assertEquals(literalTerm1.hashCode(), literalTerm2.hashCode());
    }
}
