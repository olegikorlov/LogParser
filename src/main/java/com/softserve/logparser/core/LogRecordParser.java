package com.softserve.logparser.core;

import com.softserve.logparser.core.impl.ExtendedLogRecord;

import java.util.Optional;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogRecordParser {

    private LogRecordParser() {
    }

    public static Optional<LogRecord> parse(String string) {
        if (string.length() < 1) {
            return Optional.empty();
        }
        String[] strings = string.split(" ");
        return Optional.of(ExtendedLogRecord.builder()
                .ip(strings[0])
                .build());
    }

}