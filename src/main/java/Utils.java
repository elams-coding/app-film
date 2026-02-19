import java.util.Scanner;

/**
 * Utility class providing helper methods for user input, display formatting,
 * and text manipulation.
 * This class cannot be instantiated and provides only static methods.
 * 
 * The class uses a static Scanner instance for reading user input from the
 * standard input stream.
 */
public final class Utils {

    private static final Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    private Utils() {
    }

    /**
     * Prompts the user to enter an integer within a specified range and validates
     * the input.
     * Continuously requests input until a valid integer within the range [min, max)
     * is provided.
     * 
     * @param message the prompt message to display to the user
     * @param min     the minimum acceptable value (inclusive)
     * @param max     the maximum acceptable value (exclusive)
     * @return a valid integer within the range [min, max)
     */
    public static int inputInteger(String message, int min, int max) {
        int number;
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Error. Impossible to convert '" + input + "' into integer.");
                continue;
            }

            if (number < min || number >= max) {
                System.err.println("Error. '" + number + "' is not between " + min + " and " + (max - 1));
                continue;
            }

            return number;
        }
    }

    /**
     * Displays a title to the standard output.
     * 
     * @param title the title text to display
     */
    public static void displayTitle(String title) {
        displayTitleAndSubtitle(title, null);
    }

    /**
     * Displays a title with an optional subtitle to the standard output.
     * Both title and subtitle are followed by a blank line.
     * 
     * @param title    the title text to display
     * @param subtitle the subtitle text to display, or null if no subtitle is
     *                 needed
     */
    public static void displayTitleAndSubtitle(String title, String subtitle) {
        System.out.println(title);
        if (subtitle != null) {
            System.out.println(subtitle);
        }
        System.out.println();
    }

    /**
     * Displays the provided text options to the standard output.
     * 
     * @param options the options text to display
     */
    public static void displayOptions(String options) {
        System.out.println(options);
    }

}