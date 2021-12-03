package com.softserve.logparser.core.comandline.option;

import com.softserve.logparser.core.logrecord.ExtendedLogRecord;

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
        public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
            return getStringLongMap(arg, logRecordStream
                    .map(ExtendedLogRecord::getIp), logRecordStream);
        }
    },

    // by status code
    SC(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
            String pattern = arg.equals("") ?
                    ".*" :
                    arg.replace("*", "[0-9]");
            return logRecordStream
                    .filter(logRecord -> Integer.toString(logRecord.getStatusCode()).matches(pattern))
                    .map(ExtendedLogRecord::getStatusCode)
                    .map(String::valueOf)
                    .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
        }
    },

    // by resource
    RES(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
            return getStringLongMap(arg, logRecordStream
                    .map(ExtendedLogRecord::getResource), logRecordStream);
        }
    },

    // by referrer
    REF(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
            return getStringLongMap(arg, logRecordStream
                    .map(ExtendedLogRecord::getReferrer), logRecordStream);
        }
    },

    // by size
    SIZE(OptionType.IDENTIFIER) {
        @Override
        public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
            return logRecordStream
                    .collect(Collectors.toMap(ExtendedLogRecord::getResource, ExtendedLogRecord::getSize, Long::sum, LinkedHashMap::new));
        }
    };

    private final OptionType type;

    Key(OptionType type) {
        this.type = type;
    }

    private static Map<String, Long> getStringLongMap(String arg, Stream<String> stream, Stream<ExtendedLogRecord> logRecordStream) {
        String pattern = arg.equals("") ?
                ".*" :
                arg.replace("*", ".*");
        return stream
                .filter(s -> s.matches(pattern))
                .collect(Collectors.toMap(key -> key, value -> 1L, Long::sum, LinkedHashMap::new));
    }

    public OptionType getType() {
        return type;
    }

    public Map<String, Long> apply(Stream<ExtendedLogRecord> logRecordStream, String arg) {
        return Collections.emptyMap();
    }

    public Map<String, Long> apply(Map<String, Long> map, int limit) {
        return Collections.emptyMap();
    }
}
