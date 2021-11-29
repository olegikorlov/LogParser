package com.softserve.logparser.core;

import java.nio.file.Path;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface LogParserContext extends PathHolder, KeysHolder {

    void put(Path path);

    void put(List<String> keys);

}
