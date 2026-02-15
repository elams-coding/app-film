import java.util.Scanner;

public final class Utils {
    private static final Scanner sc = new Scanner(System.in);

    private Utils() {
    }

    public static int saisirEntier(String message, int min, int max) {
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
}