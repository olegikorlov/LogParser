package com.softserve.logparser.core;

import java.nio.file.Path;
import java.util.*;

public final class LogParserContext {

    private static LogParserContext instance;
    private final Set<Path> paths;
    private final Map<String, String> keys;

    private LogParserContext() {
        this.paths = new HashSet<>();
        this.keys = new HashMap<>();
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

    public void putKeys(Map<String, String> keys) {
        this.keys.putAll(keys);
    }

    public Map<String, String> getKeys() {
        return keys;
    }

}
