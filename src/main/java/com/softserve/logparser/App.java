package com.softserve.logparser;

import com.softserve.logparser.core.*;
import com.softserve.logparser.core.impl.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String commandLine = String.join(" ", scanner.nextLine().split("\\s+"));
        System.out.println(commandLine);

        CommandLineParser commandLineParser = new CommandLineParserImpl();
        commandLineParser.parse(commandLine);

        FileReader fileReader = new FileReaderImpl();
        Stream<String> stringStream = fileReader.read();

        LogRecordParser logRecordParser = new LogRecordParserImpl(stringStream);
        Stream<LogRecord> logRecordStream = logRecordParser.parse();

        LogRecordProcessor logRecordProcessor = new LogRecordProcessorImpl(logRecordStream);
        StatInfo statInfo = logRecordProcessor.process();

        Reporter reporter = new ReporterImpl(statInfo);
        String report = reporter.buildReport();

//        System.out.println(report);
    }
}
