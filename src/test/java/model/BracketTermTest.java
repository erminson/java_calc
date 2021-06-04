package model;

import exception.TermInitializeCalculatorException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BracketTermTest {

    private static BracketTerm openingBracket;
    private static BracketTerm closingBracket;

    @BeforeClass
    public static void initBrackets() throws TermInitializeCalculatorException {
        openingBracket = new BracketTerm("(");
        closingBracket = new BracketTerm(")");
    }

    @Test
    public void shouldBeInstantiateOpeningBracket() throws TermInitializeCalculatorException {
        assertNotNull(openingBracket);
    }

    @Test
    public void shouldBeInstantiateClosingBracket() throws TermInitializeCalculatorException {
        assertNotNull(closingBracket);
    }

    @Test
    public void shouldBeCorrectBracketTypeForOpeningBracket() {
        BracketType expectedBracketType = BracketType.Opening;
        BracketType actualBracketType = openingBracket.getBracketType();
        assertEquals(expectedBracketType, actualBracketType);
    }

    @Test
    public void shouldBeCorrectBracketTypeForClosingBracket() {
        BracketType expectedBracketType = BracketType.Closing;
        BracketType actualBracketType = closingBracket.getBracketType();
        assertEquals(expectedBracketType, actualBracketType);
    }

    @Test(expected = TermInitializeCalculatorException.class)
    public void shouldBeThrowTermInitializeCalculatorException() throws TermInitializeCalculatorException {
        new BracketTerm("a");
    }

    @Test
    public void shouldBeCorrectExceptionMessage() {
        final String wrongSing = "a";
        Exception exception = assertThrows(TermInitializeCalculatorException.class, () -> {
            new BracketTerm(wrongSing);
        });

        String expectedMessage = "BracketTerm. Invalid character: " + wrongSing;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void twoSameBracketsShouldBeEquals() throws TermInitializeCalculatorException {
        BracketTerm oneBracket = new BracketTerm("(");
        BracketTerm twoBracket = new BracketTerm("(");
        assertEquals(oneBracket, twoBracket);
    }

    @Test
    public void twoSameBracketsShouldBeEqualHashCode() throws TermInitializeCalculatorException {
        BracketTerm oneBracket = new BracketTerm("(");
        BracketTerm twoBracket = new BracketTerm("(");
        assertEquals(oneBracket.hashCode(), twoBracket.hashCode());
    }

    @Test
    public void twoSameBracketsShouldEqualToString() throws TermInitializeCalculatorException {
        BracketTerm oneBracket = new BracketTerm("(");
        BracketTerm twoBracket = new BracketTerm("(");
        assertEquals(oneBracket.toString(), twoBracket.toString());
    }
}
