package com.acn3to.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * A utility class for generating large log files with random log entries.
 * The generated log files contain entries with various log levels and messages.
 */
public class LogFileGenerator {
    private static final int NUM_FILES = 5;
    private static final int NUM_LINES_PER_FILE = 100000;
    private static final String[] LOG_LEVELS = {"INFO", "DEBUG", "ERROR"};

    private static final Random random = new Random();

    /**
     * Generates log files with random log entries.
     * Creates a "logs" directory if it doesn't exist, then generates a specified number of log files.
     * Each log file contains a large number of lines with random timestamps, log levels, and messages.
     */
    public static void generateLogFiles() {
        File logDir = new File("logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        for (int i = 1; i <= NUM_FILES; i++) {
            File file = new File(logDir, "log_file_" + i + ".log");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                long startTime = System.currentTimeMillis();
                for (int j = 0; j < NUM_LINES_PER_FILE; j++) {
                    String timestamp = formatTimestamp(startTime + j * 1000);
                    String logLevel = LOG_LEVELS[random.nextInt(LOG_LEVELS.length)];
                    String message = generateRandomMessage();
                    writer.write(String.format("%s %s %s%n", timestamp, logLevel, message));
                }
                System.out.println("Generated: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error writing file: " + file.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }

    /**
     * Formats a given timestamp in milliseconds to a string representation.
     *
     * @param millis The timestamp in milliseconds.
     * @return A formatted timestamp string.
     */
    private static String formatTimestamp(long millis) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new java.util.Date(millis));
    }

    /**
     * Generates a random log message consisting of a sequence of words.
     *
     * @return A random log message.
     */
    private static String generateRandomMessage() {
        String[] words = {"Application", "started", "connected", "to", "database", "user", "logged", "in", "error", "processing", "completed", "request", "failed", "initialized"};
        int wordCount = 5 + random.nextInt(10);
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            if (i > 0) {
                message.append(" ");
            }
            message.append(words[random.nextInt(words.length)]);
        }
        return message.toString();
    }
}
