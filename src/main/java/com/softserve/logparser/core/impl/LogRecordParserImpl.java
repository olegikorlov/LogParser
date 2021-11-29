package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.LogRecordParser;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogRecordParserImpl implements LogRecordParser {

    private final Stream<String> stream;

    public LogRecordParserImpl(Stream<String> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<LogRecord> parse() {
        stream
                .limit(5)
                .forEach(System.out::println);
        return null;
    }

}
