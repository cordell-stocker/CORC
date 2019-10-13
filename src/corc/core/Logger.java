package corc.core;

import corc.structure.ICard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Logger {

    public enum Level {
        INFO, WARNING, SEVERE, FATAL
    }

    private static Level level = Level.INFO;

    private static final String INFO = "[INFO]    ";
    private static final String ERROR_WARNING = "[WARNING] ";
    private static final String ERROR_SEVERE = "[SEVERE]  ";
    private static final String ERROR_FATAL = "[FATAL]   ";

    private static boolean wasError = false;
    private static boolean wasFatal = false;
    private static Exception exception;

    private static final List<String> messages = new ArrayList<>();

    static void setLevel(Level level) {
        Logger.level = level;
    }

    public static void logInfo(String message) {
        if (Logger.level.ordinal() >= Level.INFO.ordinal()) {
            Logger.print(Logger.INFO, message);
        }
    }

    public static void logWarning(String message) {
        if (Logger.level.ordinal() >= Level.WARNING.ordinal()) {
            wasError = true;
            Logger.print(Logger.ERROR_WARNING, message);
        }
    }

    public static void logSevere(String message) {
        if (Logger.level.ordinal() >= Level.SEVERE.ordinal()) {
            wasError = true;
            Logger.print(Logger.ERROR_SEVERE, message);
        }
    }

    public static void logFatal(String message) {
        Logger.logFatal(message, null);
    }

    public static void logFatal(String message, Exception e) {
        wasError = true;
        wasFatal = true;
        Logger.print(Logger.ERROR_FATAL, message);
        Logger.exception = e;
        Control.exitProgram();
    }

    private static void print(String prefix, String message) {
        messages.add(prefix + message);
    }

    static void writeDebugIfError() {
        if (wasError) {
            writeDebug();
        }
    }

    static void writeDebug() {
        PrintWriter bufferedWriter = null;
        Date date = new Date();
        String fileName = date.getTime() + "-debug.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            bufferedWriter = new PrintWriter(writer);
            for (String message : messages) {
                bufferedWriter.append(message).append("\n");
            }
            if (exception != null) {
                exception.printStackTrace(bufferedWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    static boolean wasFatalError() {
        return wasFatal;
    }
}
