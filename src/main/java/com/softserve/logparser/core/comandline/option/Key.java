package com.softserve.logparser.core.comandline.option;

import com.softserve.logparser.core.logrecord.LogRecord;
import java.util.Collections;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public enum Key {

    // getting help information
    HELP(OptionType.METHOD),

    // limit on result
    LIMIT(OptionType.METHOD),

    // FROM DATE
    FROM(OptionType.METHOD),

    // TO DATE
    TO(OptionType.METHOD),

    // ascending order
    ASC(OptionType.METHOD) {
        @Override
        public Map<String, Long> apply(Map<String, Long> map, int limit) {
            return map
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    },

    // descending order
    DESC(OptionType.METHOD) {
        @Override
        public Map<String, Long> apply(Map<String, Long> map, int limit) {
            return map
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    },

    // by ip address
    IP(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", ".*");
            return logRecordStream
                    .map(LogRecord::getIP)
                    .filter(s -> s.matches(pattern))
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },

    // by status code
    SC(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", "[0-9]");
            return logRecordStream
                    .filter(logRecord -> Integer.toString(logRecord.getStatusCode()).matches(pattern))
                    .map(LogRecord::getStatusCode)
                    .map(String::valueOf)
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },

    // by resource
    RES(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", ".*");
            return logRecordStream
                    .map(LogRecord::getResource)
                    .filter(s -> s.matches(pattern))
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },

    // by referrer
    REF(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", ".*");
            return logRecordStream
                    .map(LogRecord::getReferrer)
                    .filter(s -> s.matches(pattern))
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },

    // by size
    SIZE(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
            return logRecordStream
                    .collect(Collectors.toMap(LogRecord::getResource, LogRecord::getSize, Long::sum, LinkedHashMap::new));
        }
    };

    private final OptionType type;

    Key(OptionType type) {
        this.type = type;
    }

    public OptionType getType() {
        return type;
    }

    public Map<String, Long> apply(Stream<LogRecord> logRecordStream, String arg) {
        return Collections.emptyMap();
    }

    public Map<String, Long> apply(Map<String, Long> map, int limit) {
        return Collections.emptyMap();
    }
}
