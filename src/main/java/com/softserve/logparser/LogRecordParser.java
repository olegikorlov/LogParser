package com.softserve.logparser;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface LogRecordParser {

    Stream<LogRecord> parse(Stream<String> stream);

}