
class App {
    private static final String TITLE;
    private static final String SUBTITLE;
    private static final StringBuilder MESSAGE_OPTIONS;

    static {
        TITLE = "MovieReviewer";
        SUBTITLE = "Get info about your movie";
        MESSAGE_OPTIONS = new StringBuilder();
    }

    public static void main(String[] args) {
        Utils.displayTitle(TITLE, SUBTITLE);
        Utils.addLineToText(MESSAGE_OPTIONS, "(1) Choix du fichier");
        Utils.addLineToText(MESSAGE_OPTIONS, "(2) Quitter");
        Utils.displayOptions(MESSAGE_OPTIONS);
    }
}