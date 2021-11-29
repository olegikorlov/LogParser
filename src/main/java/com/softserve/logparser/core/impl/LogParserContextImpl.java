package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;
import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.PathHolder;

import java.nio.file.Path;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogParserContextImpl implements LogParserContext {

    private static LogParserContext instance;
    private final PathHolder pathHolder;
    private final KeysHolder keysHolder;

    private LogParserContextImpl() {
        this.pathHolder = new PathHolderImpl();
        this.keysHolder = new KeysHolderImpl();
    }

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContextImpl();
        }
        return instance;
    }

    @Override
    public void put(Path path) {
        pathHolder.put(path);
    }

    @Override
    public Path getPath() {
        return pathHolder.getPath();
    }

    @Override
    public void put(List<String> keys) {
        keysHolder.put(keys);
    }

    @Override
    public List<String> getKeys() {
        return keysHolder.getKeys();
    }

}
