package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;
import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.PathHolder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogParserContextImpl implements LogParserContext {

    private PathHolder pathHolder;
    private KeysHolder keysHolder;

    private static LogParserContext instance;

    private LogParserContextImpl() {
        this.pathHolder = new PathHolderImpl(Path.of(""));
        this.keysHolder = new KeysHolderImpl(new ArrayList<>());
    }

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContextImpl();
        }
        return instance;
    }

    @Override
    public void put(Path path) {
        this.pathHolder = new PathHolderImpl(path);
    }

    @Override
    public void put(List<String> keys) {
        this.keysHolder = new KeysHolderImpl(keys);
    }

    @Override
    public Path getPath() {
        return pathHolder.getPath();
    }

    @Override
    public List<String> getKeys() {
        return keysHolder.getKeys();
    }

}
