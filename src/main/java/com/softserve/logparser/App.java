package com.softserve.logparser;

import com.softserve.logparser.core.*;
import com.softserve.logparser.core.impl.FileReaderImpl;

import java.io.IOException;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        CommandLineParser commandLineParser = string -> {
            return null;
        };
        KeysAndPathHolder keysAndPathHolder = commandLineParser.parse("");

        FileReader fileReader = new FileReaderImpl();
        Stream<String> stringStream = fileReader.read();

        LogRecordParser logRecordParser = stream -> {
            return null;
        };
        Stream<LogRecord> logRecordStream1 = logRecordParser.parse(stringStream);

        LogRecordProcessor logRecordProcessor = (logRecordStream) -> {
            return null;
        };
        StatInfo statInfo1 = logRecordProcessor.process(logRecordStream1);

        Reporter reporter = statInfo -> {
            return null;
        };
        String report = reporter.buildReport(statInfo1);

        System.out.println(report);
    }
}
