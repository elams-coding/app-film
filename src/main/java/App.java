class App {
    private static final String TITLE = "MovieReviewer";
    private static final String SUBTITLE = "Get info about your movie";
    private static String messageOptions;

    private App() {
        messageOptions = "\n(1) Lire fichier CSV";
        messageOptions += "\n(2) Quittez";
    }

    public static void main(String[] args) {
        displayTitle();
        displayOptions();
    }

    private static void displayTitle() {
        System.out.println(TITLE);
        System.out.println(SUBTITLE);
    }

    static void displayOptions() {
        System.out.println(messageOptions);
    }

    public static void setMessageOptions(String newMessageOptions) {
        messageOptions = newMessageOptions;
    }
}