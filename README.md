# Log Processor

## Overview

A Java application designed to process large volumes of log files. The application reads log files, counts the occurrences of a specific word, and leverages parallel programming to enhance processing efficiency.

## Features

- **LogProcessor**: Processes a single log file to count occurrences of a specific word with case-insensitive matching.
- **ParallelLogProcessor**: Manages parallel processing of multiple log files using a thread pool.
- **LogFileGenerator**: Generates multiple large log files with random log messages.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6.0 or later

### Setup

1. **Clone the Repository**

    ```bash
    git clone git@github.com:acn3to/log-processor.git
    cd log-processor
    ```

2. **Build the Project**

    ```bash
    mvn clean install
    ```

3. **Generate Log Files**

   The `LogFileGenerator` class is called automatically when you run the application. It generates multiple large log files in the `logs` directory. You can modify the log generation settings (such as the number of files and lines per file) directly in the `LogFileGenerator` class.

4. **Run the Application**

    ```bash
    mvn exec:java -Dexec.mainClass="com.acn3to.Main"
    ```

   This will generate the log files and then process them to count occurrences of the specified word.

## Usage

- **LogFileGenerator**: Creates log files with random content based on predefined settings in the `LogFileGenerator` class.
- **Main Class**: Executes the generation of log files and then processes them to count occurrences of the specified word.

## Contributing

Feel free to open issues or submit pull requests. For more details, please refer to the contributing guidelines.
