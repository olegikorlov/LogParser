package com.softserve.logparser.core;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface LogParserContext {

    void put(PathHolder pathHolder);

    void put(KeysHolder keysHolder);

    PathHolder getPathHolder();

    KeysHolder getKeysHolder();


}
