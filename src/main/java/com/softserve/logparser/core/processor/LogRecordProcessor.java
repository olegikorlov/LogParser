package com.softserve.logparser.core.processor;

import com.softserve.logparser.core.comandline.option.Key;
import com.softserve.logparser.core.comandline.option.Option;
import com.softserve.logparser.core.comandline.option.OptionType;
import com.softserve.logparser.core.context.LogParserContext;
import com.softserve.logparser.core.logrecord.LogRecord;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public final class LogRecordProcessor {

    private LogRecordProcessor() {
    }

    public static StatInfo process(Stream<LogRecord> logRecordStream) {
        LogParserContext context = LogParserContext.getInstance();
        Set<Option> keys = context.getKeys();

        if (keys.contains(new Option(Key.HELP))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Usage: logparser [OPTION]... [FILE]...\n")
                    .append("list of options:\n");
            for (Key key : Key.values()) {
                stringBuilder.append(String.format(" --%s%n", key.name().toLowerCase(Locale.ROOT)));
            }
            Map<String, Long> map = new HashMap<>();
            map.put(String.format("%n%s", stringBuilder), 0L);
            return new StatInfoImpl(map);
        }

        LocalDateTime fromDate = LocalDateTime.parse(getFromDate(keys));
        LocalDateTime toDate = LocalDateTime.parse(getToDate(keys));
        int limit = getLimit(keys);

        Stream<LogRecord> logRecordFilteredByDate = logRecordStream
                .filter(logRecord -> logRecord.getTimeStamp().toLocalDateTime().isAfter(fromDate)
                        && logRecord.getTimeStamp().toLocalDateTime().isBefore(toDate));

        Option identifierOption = keys.stream()
                .filter(option -> option.getType().equals(OptionType.IDENTIFIER))
//                .peek(System.out::println)
                .findFirst()
                .orElse(new Option(Key.IP));

        Map<String, Long> map = identifierOption.getKey().apply(logRecordFilteredByDate, identifierOption.getValue());

        Key orderKey = keys.stream()
                .map(Option::getKey)
                .filter(key -> key.equals(Key.ASC) || key.equals(Key.DESC))
                .findFirst()
                .orElse(Key.DESC);

        return new StatInfoImpl(orderKey.apply(map, limit));
    }

    private static int getLimit(Set<Option> keys) {
        return keys.stream()
                .filter(option -> option.equals(new Option(Key.LIMIT)))
                .findFirst()
                .map(Option::getValue)
                .map(Integer::parseInt)
                .orElse(Integer.MAX_VALUE);
    }

    private static String getFromDate(Set<Option> keys) {
        return keys.stream()
                .filter(option -> option.equals(new Option(Key.FROM)))
                .map(Option::getValue)
                .findFirst()
                .orElse(LocalDateTime.MIN.toString());
    }

    private static String getToDate(Set<Option> keys) {
        return keys.stream()
                .filter(option -> option.equals(new Option(Key.TO)))
                .map(Option::getValue)
                .findFirst()
                .orElse(LocalDateTime.MAX.toString());
    }

}
