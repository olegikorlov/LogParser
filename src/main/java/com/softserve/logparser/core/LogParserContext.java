package com.softserve.logparser.core;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogParserContext {

    private static LogParserContext instance;
    private final Set<Path> paths;
    private final List<String> keys;

    private LogParserContext() {
        this.paths = new HashSet<>();
        this.keys = new ArrayList<>();
    }

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContext();
        }
        return instance;
    }

    public Set<Path> getPaths() {
        return paths;
    }

    public void putPaths(Set<Path> paths) {
        this.paths.addAll(paths);
    }

    public void putKeys(List<String> keys) {
        this.keys.addAll(keys);
    }

    public List<String> getKeys() {
        return keys;
    }

}
