package com.softserve.logparser;

import com.softserve.logparser.core.*;
import com.softserve.logparser.core.impl.*;

import java.io.IOException;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        CommandLineParser commandLineParser = new CommandLineParserImpl();
        commandLineParser.parse(args);

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
