package com.softserve.logparser.core.processor;

import com.softserve.logparser.core.comandline.option.Key;
import com.softserve.logparser.core.comandline.option.Option;
import com.softserve.logparser.core.comandline.option.OptionType;
import com.softserve.logparser.core.context.LogParserContext;
import com.softserve.logparser.core.logrecord.ExtendedLogRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogRecordProcessor {

    public static StatInfo process(Stream<ExtendedLogRecord> logRecordStream) {
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
            return new StatInfo(map, List.of(new Option(Key.HELP)));
        }

        LocalDateTime fromDate = LocalDateTime.parse(getFromDate(keys));
        LocalDateTime toDate = LocalDateTime.parse(getToDate(keys));
        int limit = getLimit(keys);

        Stream<ExtendedLogRecord> logRecordFilteredByDate = logRecordStream
                .filter(logRecord -> logRecord.getTimeStamp().toLocalDateTime().isAfter(fromDate)
                        && logRecord.getTimeStamp().toLocalDateTime().isBefore(toDate));

        Option identifierOption = keys.parallelStream()
                .filter(option -> option.getKey().getType().equals(OptionType.IDENTIFIER))
                .findFirst()
                .orElse(new Option(Key.IP));

        Map<String, Long> map = identifierOption.getKey().apply(logRecordFilteredByDate, identifierOption.getValue());

        Key orderKey = keys.parallelStream()
                .map(Option::getKey)
                .filter(key -> key.equals(Key.ASC) || key.equals(Key.DESC))
                .findFirst()
                .orElse(Key.DESC);

        List<Option> info = List.of(identifierOption);


        return new StatInfo(orderKey.apply(map, limit), info);
    }

    private static int getLimit(Set<Option> keys) {
        return keys.parallelStream()
                .filter(option -> option.equals(new Option(Key.LIMIT)))
                .findFirst()
                .map(Option::getValue)
                .map(Integer::parseInt)
                .orElse(Integer.MAX_VALUE);
    }

    private static String getFromDate(Set<Option> keys) {
        return keys.parallelStream()
                .filter(option -> option.equals(new Option(Key.FROM)))
                .map(Option::getValue)
                .findFirst()
                .orElse(LocalDateTime.MIN.toString());
    }

    private static String getToDate(Set<Option> keys) {
        return keys.parallelStream()
                .filter(option -> option.equals(new Option(Key.TO)))
                .map(Option::getValue)
                .findFirst()
                .orElse(LocalDateTime.MAX.toString());
    }

}
