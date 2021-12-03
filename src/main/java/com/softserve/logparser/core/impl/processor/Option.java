package com.softserve.logparser.core.impl.processor;

import com.softserve.logparser.core.LogRecord;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Option {

    IP {
        @Override
        protected Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", ".*");
            return logRecordStream
                    .map(LogRecord::getIP)
                    .filter(s -> s.matches(pattern))
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },
    RES {
        @Override
        protected Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", ".*");
            return logRecordStream
                    .map(LogRecord::getResource)
                    .filter(s -> s.matches(pattern))
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },
    SC {
        @Override
        protected Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", "[0-9]");
            return logRecordStream
                    .filter(s -> Integer.toString(s.getStatusCode()).matches(pattern))
                    .map(LogRecord::getResource)
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },
    SIZE {
        @Override
        protected Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            return logRecordStream
                    .collect(Collectors.toMap(LogRecord::getResource, LogRecord::getSize, Long::sum, LinkedHashMap::new));
        }
    };

    protected abstract Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg);
}
