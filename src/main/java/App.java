
/**
 * App is the main entry point of the MovieReviewer application.
 * 
 * It manages the initialization of the application, displays menu options to
 * the user,
 * and handles user input to execute corresponding actions.
 * 
 * The application displays a title and subtitle along with menu options:
 * (1) Choose a file
 * (2) Quit
 * 
 * Static Fields:
 * - TITLE: The title of the application ("MovieReviewer")
 * - SUBTITLE: The subtitle describing the app ("Get info about your movie")
 * - MESSAGE_OPTIONS: A StringBuilder containing all available menu options
 * 
 * Methods:
 * - main(String[] args): Entry point that initializes the app and processes
 * user choices
 * - initialisation(): Sets up the application by displaying the title,
 * subtitle, and menu options
 * - chooseOption(): Prompts the user to select an option (1 or 2) and returns
 * their choice
 * - executeChoice(int choice): Executes the action corresponding to the user's
 * choice,
 * or recursively requests re-entry if an invalid choice is made
 */
class App {

    private static final String TITLE;
    private static final String SUBTITLE;
    private static final String MESSAGE_OPTIONS;

    private App() {
    }

    static {
        TITLE = "MovieReviewer";
        SUBTITLE = "Get info about your movie";
        MESSAGE_OPTIONS = """
                (1) Choose file
                (2) Quit
                """;

    }

    public static void main(String[] args) {
        start();
    }

    /**
     * Initializes the application by displaying the title, subtitle, and available
     * menu options.
     * Populates the MESSAGE_OPTIONS with available choices and displays them to the
     * user.
     */
    private static void initialisation() {
        Utils.displayTitleAndSubtitle(TITLE, SUBTITLE);
        Utils.displayOptions(MESSAGE_OPTIONS);
    }

    /**
     * Starts the main application loop.
     * <p>
     * This method repeatedly displays the menu, collects the user's choice,
     * and delegates execution to {@link #executeChoice(int)}. The loop continues
     * until the user selects the quit option.
     * </p>
     */
    private static void start() {
        boolean running = true;

        while (running) {
            initialisation();
            int choice = chooseOption();
            running = executeChoice(choice);
        }
    }

    private static int chooseOption() {
        return Utils.inputInteger("Tap 1 or 2 : ", 1, 3);
    }

    /**
     * Executes the action corresponding to the user's selected choice.
     * 
     * Handles two cases:
     * - Choice 1:
     * - Choice 2: Exit the application
     * 
     * @param choice the user's selected option
     */
    private static boolean executeChoice(int choice) {
        System.out.println();
        switch (choice) {
            case 1 -> {
                // todo : implement the next step
                return true;
            }
            case 2 -> {
                quit();
                return false;
            }
        }
        throw new IllegalStateException("Invalid choice: " + choice);
    }

    private static void quit() {
        System.out.println("Bye");
    }

}