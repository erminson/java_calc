package view;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.IValidator;
import util.Validator;
import view.IView;
import view.TerminalView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TerminalViewTest {
    private static TerminalView terminalView;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeClass
    public static void initView() {
        IValidator validator = new Validator();
        terminalView = new TerminalView(validator);
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldBeCorrectOutputResultExpression() {
        terminalView.printResult(new BigDecimal(5));
        assertEquals("Result: 5.00", outputStreamCaptor.toString().trim());
    }

    @Test
    public void shouldBeCorrectInputResultExpression() {
        String expectedResult = "2 + 4 - 1";
        Scanner scanner = new Scanner(expectedResult);
        String actualResult = terminalView.readExpression(scanner);
        assertEquals(expectedResult, actualResult);
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
