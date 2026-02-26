import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilsTest {
    private Scanner mock_scanner;
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
        mock_scanner = mock(Scanner.class);
    }

    @Test
    public void testInputIntegerValidInput() {
        String testedValue = "5";
        // simulate user's input
        when(mock_scanner.nextLine()).thenReturn(testedValue);

        // test the method with the mock
        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    public void testInputIntegerInvalidInput() {
        String testedValue = "6";
        when(mock_scanner.nextLine()).thenReturn("abc").thenReturn(testedValue);

        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    public void testInputIntegerWhiteSpace() {
        String testedValue = "7";
        String space = " ";
        when(mock_scanner.nextLine()).thenReturn(space).thenReturn(testedValue);

        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    public void testInputIntegerEmpty() {
        String testedValue = "8";
        String emptyString = "";
        when(mock_scanner.nextLine()).thenReturn(emptyString).thenReturn(testedValue);

        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    public void testInputMinValue() {
        String testedValue = String.valueOf(MINIMUM);
        // simulate user's input
        // first entry minimum value - 1 (0)
        // then minimum value (1)
        when(mock_scanner.nextLine()).thenReturn(String.valueOf(MINIMUM - 1)).thenReturn(testedValue);

        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

    @Test
    public void testInputMaxValue() {
        String testedValue = String.valueOf(MAXIMUM - 1);
        // simulate user's input
        // first entry maximum value (10)
        // then maximum value - 1 (9)
        when(mock_scanner.nextLine()).thenReturn(String.valueOf(MAXIMUM)).thenReturn(testedValue);

        int result = Utils.inputInteger(mock_scanner, MESSAGE, MINIMUM, MAXIMUM);
        assertEquals(Integer.parseInt(testedValue), result);
    }

}
