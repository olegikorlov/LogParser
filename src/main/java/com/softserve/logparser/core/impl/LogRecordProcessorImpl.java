package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;
import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.LogRecordProcessor;
import com.softserve.logparser.core.StatInfo;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class LogRecordProcessorImpl implements LogRecordProcessor {

    private KeysHolder keysHolder;

    public LogRecordProcessorImpl() {
        this.keysHolder = LogParserContextImpl.getInstance().getKeysHolder();
    }

    @Override
    public StatInfo process(Stream<LogRecord> logRecordStream) {
        return null;
    }

}
