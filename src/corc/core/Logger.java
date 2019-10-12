package corc.core;

import corc.structure.ICard;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Logger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static final String INFO = Logger.ANSI_WHITE + "[INFO]    ";
    private static final String ERROR_WARNING = Logger.ANSI_YELLOW + "[WARNING] ";
    private static final String ERROR_SEVERE = Logger.ANSI_RED + "[SEVERE]  ";

    public static void printInfo(String message) {
            Logger.print(Logger.INFO, message);

    }

    public static void printWarning(String message) {
            Logger.print(Logger.ERROR_WARNING, message);

    }
    public static void printSevere(String message) {
            Logger.print(Logger.ERROR_SEVERE, message);

    }

    private static void print(String prefix, String message) {
        System.out.println(prefix + message + Logger.ANSI_RESET);
    }

    public static String cardsAsString(ICard[] cards) {
        return Logger.cardsAsString(Arrays.asList(cards));
    }

    public static String cardsAsString(List<? extends ICard> cards) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < cards.size() - 1; i++) {
            sb.append(cards.get(i).getDescription()).append(", ");
        }
        if (cards.size() > 0) {
            sb.append(cards.get(cards.size() - 1).getDescription());
        }
        sb.append("]");
        return sb.toString();
    }
}
