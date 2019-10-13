package corc.core;

import corc.structure.ICard;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Control {

    private static boolean alwaysCreateDebug = false;

    public static void setAlwaysCreateDebug(boolean alwaysCreateDebug) {
        Control.alwaysCreateDebug = alwaysCreateDebug;
    }

    public static void exitProgram() {
        if (alwaysCreateDebug) {
            Logger.writeDebug();
        } else {
            Logger.writeDebugIfError();
        }
        if (Logger.wasFatalError()) {
            System.err.println("Fatal Error. Check log for more information.");
            System.exit(-1);
        } else {
            System.exit(0);
        }
    }

    public static void setDebugLevel(Logger.Level level) {
        Logger.setLevel(level);
    }

    public static String cardsAsString(ICard[] cards) {
        return Control.cardsAsString(Arrays.asList(cards));
    }

    @SuppressWarnings("WeakerAccess")
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
