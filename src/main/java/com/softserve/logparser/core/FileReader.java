package com.softserve.logparser.core;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface FileReader {

    Stream<String> read() throws IOException;

}
