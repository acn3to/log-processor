package com.acn3to;

import com.acn3to.utils.LogFileGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The Main class serves as the entry point for the log file processing application.
 * It generates log files, initializes the log processing, and outputs the total occurrences
 * of a specific word in the generated log files.
 */
public class Main {

    /**
     * The main method that executes the log file processing workflow.
     * It generates log files, creates a list of generated log files, specifies the word to count,
     * and then processes the log files to count occurrences of the specified word.
     * Finally, it prints the total count of occurrences to the console.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        LogFileGenerator.generateLogFiles();

        List<String> logFiles = Arrays.asList(
                "logs/log_file_1.log",
                "logs/log_file_2.log",
                "logs/log_file_3.log",
                "logs/log_file_4.log",
                "logs/log_file_5.log"
        );

        String wordToCount = "useR";

        try {
            ParallelLogProcessor processor = new ParallelLogProcessor();

            int totalOccurrences = processor.processLogs(logFiles, wordToCount);

            System.out.println("Total occurrences of \"" + wordToCount + "\": " + totalOccurrences);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
