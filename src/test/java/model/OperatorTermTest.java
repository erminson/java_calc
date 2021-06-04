package model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTermTest {
    private static OperatorTerm operatorTerm1;
    private static OperatorTerm operatorTerm2;

    @BeforeClass
    public static void initOperatorTerms() {
        operatorTerm1 = new OperatorTerm(OperatorType.Addition);
        operatorTerm2 = new OperatorTerm(OperatorType.Addition);
    }

    @Test
    public void typeShouldBeEqualAddition() {
        OperatorType expectedType = OperatorType.Addition;
        OperatorType actualType = operatorTerm1.getOperatorType();
        assertEquals(expectedType, actualType);
    }

    @Test
    public void twoSameOperatorTermShouldBeEqual() {
        assertEquals(operatorTerm1, operatorTerm2);
    }

    @Test
    public void twoSameOperatorShouldEqualTypes() {
        assertEquals(operatorTerm1.getOperatorType(), operatorTerm2.getOperatorType());
    }

    @Test
    public void twoSameOperatorShouldEqualToString() {
        assertEquals(operatorTerm1.toString(), operatorTerm2.toString());
    }

    @Test
    public void twoSameOperatorShouldEqualHashCode() {
        assertEquals(operatorTerm1.hashCode(), operatorTerm2.hashCode());
    }

}
