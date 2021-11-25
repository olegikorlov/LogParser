package com.softserve.logparser;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface FileReader {

    Stream<String> read(PathHolder path) throws IOException;

}
