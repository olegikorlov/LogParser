package com.softserve.logparser;

import com.softserve.logparser.core.comandline.CommandLineParser;
import com.softserve.logparser.core.filereader.FileReader;
import com.softserve.logparser.core.logrecord.LogRecord;
import com.softserve.logparser.core.logrecord.LogRecordParser;
import com.softserve.logparser.core.processor.LogRecordProcessor;
import com.softserve.logparser.core.processor.StatInfo;
import com.softserve.logparser.core.reporter.Reporter;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {

        CommandLineParser.parse(args);
        Stream<String> stringStream = FileReader.read();
        Stream<LogRecord> logRecordStream = stringStream
                .map(LogRecordParser::parse)
                .filter(Predicate.not(Optional::isEmpty))
                .map(Optional::get);

        StatInfo statInfo = LogRecordProcessor.process(logRecordStream);

        Reporter.buildReport(statInfo, System.out::println);

    }

}