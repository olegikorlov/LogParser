package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.LogParserContext;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogParserContextImpl implements LogParserContext {

    private static LogParserContext instance;
    private final Set<Path> paths;
    private final List<String> keys;

    private LogParserContextImpl() {
        this.paths = new HashSet<>();
        this.keys = new ArrayList<>();
    }

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContextImpl();
        }
        return instance;
    }

    @Override
    public Set<Path> getPaths() {
        return paths;
    }

    @Override
    public void putPaths(Set<Path> paths) {
        this.paths.addAll(paths);
    }

    @Override
    public void putKeys(List<String> keys) {
        this.keys.addAll(keys);
    }

    @Override
    public List<String> getKeys() {
        return keys;
    }

}
