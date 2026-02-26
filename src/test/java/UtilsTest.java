import java.util.Scanner;

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

    static {
        MINIMUM = 1;
        MAXIMUM = 10;
        MESSAGE = "Enter number: ";
    }

    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
    }

    @Test
    void testInputIntegerValidInput() {
        String testedValue = "5";
        // simulate user's input
        when(mockScanner.nextLine()).thenReturn(testedValue);

        // test the method with the mock
        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerInvalidInput() {
        String testedValue = "6";
        when(mockScanner.nextLine()).thenReturn("abc").thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerWhiteSpace() {
        String testedValue = "7";
        String space = " ";
        when(mockScanner.nextLine()).thenReturn(space).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    void testInputIntegerEmpty() {
        String testedValue = "8";
        String emptyString = "";
        when(mockScanner.nextLine()).thenReturn(emptyString).thenReturn(testedValue);

        int result = Utils.inputInteger(mockScanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
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

}
