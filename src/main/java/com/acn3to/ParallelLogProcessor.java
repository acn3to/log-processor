package com.acn3to;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Manages parallel execution of LogProcessor tasks using an ExecutorService.
 */
public class ParallelLogProcessor {

    /**
     * Processes multiple log files in parallel to count occurrences of a specific word.
     *
     * @param logFiles A list of paths to log files.
     * @param wordToCount The word to be counted in the log files.
     * @return The total number of occurrences of the word across all log files.
     * @throws InterruptedException If the processing is interrupted.
     * @throws ExecutionException If an error occurs during processing.
     */
    public int processLogs(List<String> logFiles, String wordToCount) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(logFiles.size());
        try {
            List<Future<Integer>> futures = logFiles.stream()
                    .map(filePath -> new LogProcessor(filePath, wordToCount))
                    .map(executorService::submit)
                    .toList();

            int totalOccurrences = 0;
            for (Future<Integer> future : futures) {
                totalOccurrences += future.get();
            }

            return totalOccurrences;
        } finally {
            executorService.shutdown();
        }
    }
}
