package com.softserve.logparser.core.impl.processor;

import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.LogRecordProcessor;
import com.softserve.logparser.core.StatInfo;
import com.softserve.logparser.core.impl.StatInfoImpl;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public final class LogRecordProcessorImpl implements LogRecordProcessor {

    @Override
    public StatInfo process(Stream<LogRecord> logRecordStream) {
        LogParserContext context = LogParserContext.getInstance();
        Map<String, String> keys = context.getKeys();

        LocalDateTime dateFrom = LocalDateTime.parse(keys.getOrDefault("FROM", LocalDateTime.MIN.toString()));
        LocalDateTime dateBefore = LocalDateTime.parse(keys.getOrDefault("TO", LocalDateTime.MAX.toString()));

        int limit = Integer.parseInt(keys.getOrDefault("L", Integer.toString(Integer.MAX_VALUE)));

        Stream<LogRecord> filteredStream = logRecordStream
                .filter(s -> s.getTimeStamp().toLocalDateTime().isAfter(dateFrom) && s.getTimeStamp().toLocalDateTime().isBefore(dateBefore));

        String mainOption = keys.keySet().stream()
                .filter(k -> k.equals("IP") || k.equals("RES") || k.equals("SC") || k.equals("SIZE"))
                .findFirst()
                .orElse("IP");
        Map<String, Long> map = Option.valueOf(mainOption).apply(filteredStream, keys.getOrDefault(mainOption, ""));

        String order = keys.keySet().stream()
                .filter(k -> k.equals("A") || k.equals("D"))
                .findFirst()
                .orElse("N");

        map = Order.valueOf(order).apply(map, limit);

        List<String> list = List.of(
                mainOption, keys.getOrDefault(mainOption, ""), order);

        return new StatInfoImpl(map, list);
    }
}
