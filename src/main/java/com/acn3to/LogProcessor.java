package com.acn3to;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * A Callable class that processes a log file to count occurrences of a specific word.
 */
public class LogProcessor implements Callable<Integer> {
    private final String filePath;
    private final String wordToCount;

    /**
     * Constructs a LogProcessor.
     *
     * @param filePath The path to the log file.
     * @param wordToCount The word to be counted in the log file.
     */
    public LogProcessor(String filePath, String wordToCount) {
        this.filePath = filePath;
        this.wordToCount = wordToCount.toLowerCase();
    }

    /**
     * Reads the log file and counts occurrences of the specified word.
     *
     * @return The number of occurrences of the word in the file.
     */
    @Override
    public Integer call() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(wordToCount)) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the log file: " + filePath, e);
        }
        return count;
    }
}
