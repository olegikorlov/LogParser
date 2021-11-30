package com.softserve.logparser;

import com.softserve.logparser.core.*;
import com.softserve.logparser.core.impl.CommandLineParserImpl;
import com.softserve.logparser.core.impl.FileReaderImpl;
import com.softserve.logparser.core.impl.LogRecordProcessorImpl;
import com.softserve.logparser.core.impl.ReporterImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        CommandLineParser commandLineParser = new CommandLineParserImpl();
        commandLineParser.parse(args);

        FileReader fileReader = new FileReaderImpl();
        Stream<String> stringStream = fileReader.read();
        Stream<LogRecord> logRecordStream = stringStream
                .map(LogRecordParser::parse)
                .filter(Predicate.not(Optional::isEmpty))
                .map(Optional::get);

        // test
        logRecordStream
                .limit(5)
                .forEach(System.out::println);

        LogRecordProcessor logRecordProcessor = new LogRecordProcessorImpl(logRecordStream);
        StatInfo statInfo = logRecordProcessor.process();

        Reporter reporter = new ReporterImpl(statInfo);
        reporter.buildReport(System.out::println);

    }
    
}