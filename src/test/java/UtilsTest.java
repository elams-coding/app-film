import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilsTest {
    private Scanner mockScanner;
    private static final int MINIMUM;
    private static final int MAXIMUM;
    private static final String MESSAGE;
    private static final String TITLE;
    private static final String SUBTITLE;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    static {
        MINIMUM = 1;
        MAXIMUM = 10;
        MESSAGE = "Enter number: ";
        TITLE = "MovieReviewer";
        SUBTITLE = "Get info about your movie";
    }

    @SuppressWarnings("unused")
    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
    }

    @SuppressWarnings("unused")
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testInputIntegerValidInput() {
        String testedValue = "4";
        // simulate user's input
        when(mockScanner.nextLine()).thenReturn(testedValue);

        // test the method with the mock
        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerInvalidInput() {
        String testedValue = "5";
        when(mockScanner.nextLine()).thenReturn("abc").thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerWhiteSpace() {
        String testedValue = "6";
        String space = " ";
        when(mockScanner.nextLine()).thenReturn(space).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerEmpty() {
        String testedValue = "7";
        String emptyString = "";
        when(mockScanner.nextLine()).thenReturn(emptyString).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerWithSurroundingSpaces() {
        when(mockScanner.nextLine()).thenReturn(" 8 ");

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(8, result);
    }

    @Test
    void testInputMinValue() {
        String testedValue = String.valueOf(MINIMUM);
        // simulate user's input
        // first entry minimum value - 1 (0)
        // then minimum value (1)
        when(mockScanner.nextLine()).thenReturn(String.valueOf(MINIMUM - 1)).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputMaxValue() {
        String testedValue = String.valueOf(MAXIMUM - 1);
        // simulate user's input
        // first entry maximum value (10)
        // then maximum value - 1 (9)
        when(mockScanner.nextLine()).thenReturn(String.valueOf(MAXIMUM)).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testDisplayTitle() {
        // capture System.out
        System.setOut(new PrintStream(outContent));

        Utils.displayTitle(TITLE);

        String expectedOutput = TITLE + System.lineSeparator() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    void testDisplayTitleAndSubtitle() {
        System.setOut(new PrintStream(outContent));

        Utils.displayTitleAndSubtitle(TITLE, SUBTITLE);

        String expectedOutput = TITLE + System.lineSeparator() +
                SUBTITLE + System.lineSeparator() + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDisplayOptions() {
        System.setOut(new PrintStream(outContent));

        Utils.displayOptions("1. Option A");

        String expectedOutput = "1. Option A" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

}
