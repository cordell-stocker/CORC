package core;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Console {

    public static boolean printInfo = true;
    public static boolean printWarning = true;
    public static boolean printSevere = true;

    private static final String ANSI_RESET = "\u001B[0m";
    //private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    //private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    //private static final String ANSI_BLUE = "\u001B[34m";
    //private static final String ANSI_PURPLE = "\u001B[35m";
    //private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static final String INFO = Console.ANSI_WHITE + "[INFO]    ";
    private static final String ERROR_WARNING = Console.ANSI_YELLOW + "[WARNING] ";
    private static final String ERROR_SEVERE = Console.ANSI_RED + "[SEVERE]  ";

    public static void printInfo(String message) {
        if (Console.printInfo) {
            Console.print(Console.INFO, message);
        }
    }

    public static void printWarning(String message) {
        if (Console.printWarning) {
            Console.print(Console.ERROR_WARNING, message);
        }
    }
    public static void printSevere(String message) {
        if (Console.printSevere) {
            Console.print(Console.ERROR_SEVERE, message);
        }
    }

    private static void print(String prefix, String message) {
        System.out.println(prefix + message + Console.ANSI_RESET);
    }
}
