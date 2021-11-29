package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.LogRecordProcessor;
import com.softserve.logparser.core.StatInfo;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogRecordProcessorImpl implements LogRecordProcessor {

    private final LogParserContext context;

    private Stream<LogRecord> logRecordStream;

    public LogRecordProcessorImpl(Stream<LogRecord> logRecordStream) {
        this.context = LogParserContextImpl.getInstance();
        this.logRecordStream = logRecordStream;
    }

    @Override
    public StatInfo process() {
        List<String> keys = context.getKeys();
        System.out.println(String.join(", ", keys));
        return null;
    }

}
