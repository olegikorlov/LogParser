package com.softserve.logparser;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface LogRecordProcessor {

    StatInfo process(Stream<LogRecord> logRecordStream, KeysHolder keysHolder);

}
