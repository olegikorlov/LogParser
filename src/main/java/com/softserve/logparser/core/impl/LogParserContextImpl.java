package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;
import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.PathHolder;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class LogParserContextImpl implements LogParserContext {

    private PathHolder pathHolder;
    private KeysHolder keysHolder;

    private static LogParserContext instance;

    private LogParserContextImpl() {
    }

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContextImpl();
        }
        return instance;
    }

    @Override
    public void put(PathHolder pathHolder) {
        this.pathHolder = pathHolder;
    }

    @Override
    public void put(KeysHolder keysHolder) {
        this.keysHolder = keysHolder;
    }

    @Override
    public PathHolder getPathHolder() {
        return pathHolder;
    }

    @Override
    public KeysHolder getKeysHolder() {
        return keysHolder;
    }

}
