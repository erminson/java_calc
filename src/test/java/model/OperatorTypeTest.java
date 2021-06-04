package model;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OperatorTypeTest {
    private static OperatorType additionOperatorType1;
    private static OperatorType additionOperatorType2;
    private static OperatorType multiplicationOperatorType;

    @BeforeClass
    public static void initOperatorTypes() {
        additionOperatorType1 = OperatorType.Addition;
        additionOperatorType2 = OperatorType.Addition;
        multiplicationOperatorType = OperatorType.Multiplication;
    }

    @Test
    public void additionShouldBeLessThanMultiplication() {
        assertTrue( additionOperatorType1.getPriority() < multiplicationOperatorType.getPriority());
    }

    @Test
    public void twoSameOperatorTypeShouldBeEqualPriority() {
        assertEquals(additionOperatorType1.getPriority(), additionOperatorType2.getPriority());
    }

    @Test
    public void additionOperatorTypePriorityShouldBeEqualOne() {
        assertEquals(1, additionOperatorType1.getPriority());
    }

    @Test
    public void twoSameOperatorTypeShouldEqualToString() {
        assertEquals(additionOperatorType1.toString(), additionOperatorType2.toString());
    }

    @Test
    public void additionOperatorTypeShouldEqualPlus() {
        assertEquals("+", additionOperatorType2.toString());
    }

    @Test
    public void subtractionOperatorTypeShouldEqualMinus() {
        assertEquals("-", OperatorType.Subtraction.toString());
    }

    @Test
    public void multiplicationOperatorTypeShouldEqualMultiply() {
        assertEquals("*", multiplicationOperatorType.toString());
    }

    @Test
    public void divisionOperatorTypeShouldEqualDivision() {
        assertEquals("/", OperatorType.Division.toString());
    }

    @Test
    public void arrayShouldBeSortedBasedPriority() {
        OperatorType[] expected = new OperatorType[] {OperatorType.Addition, OperatorType.Multiplication};
        OperatorType[] actual = new OperatorType[] {OperatorType.Multiplication, OperatorType.Addition};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareAdditionWithMultiplicationShouldBeReturnMinusOne() {
        assertTrue(additionOperatorType1.compare(additionOperatorType1, multiplicationOperatorType) == -1);
    }
}
