package com.softserve.logparser.core.impl.processor;

import com.softserve.logparser.core.LogRecord;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public enum Identifier {

    IP {
        @Override
        protected Stream<String> apply(Stream<LogRecord> logRecordStream, String identifierArg) {
            return logRecordStream
                    .map(LogRecord::getIP)
                    .filter(s -> Pattern.matches(identifierArg, s));
        }
    },
    RES {
        @Override
        protected Stream<String> apply(Stream<LogRecord> logRecordStream, String identifierArg) {
            return logRecordStream
                    .map(LogRecord::getResource)
                    .filter(s -> Pattern.matches(identifierArg, s));
        }
    },
    SC {
        @Override
        protected Stream<String> apply(Stream<LogRecord> logRecordStream, String identifierArg) {
            String temp = identifierArg.replace("x", ".");
            return logRecordStream
                    .filter(logRecord -> Pattern.matches(temp, Integer.toString(logRecord.getStatusCode())))
                    .map(LogRecord::getResource);
        }
    };

    protected abstract Stream<String> apply(Stream<LogRecord> logRecordStream, String identifierArg);
}
