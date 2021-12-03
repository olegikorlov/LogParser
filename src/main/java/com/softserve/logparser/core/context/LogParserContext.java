package com.softserve.logparser.core.context;

import com.softserve.logparser.core.comandline.option.Option;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogParserContext {

    private static LogParserContext instance;
    private final Set<Path> paths;
    private final Set<Option> keys;

    private LogParserContext() {
        this.paths = new HashSet<>();
        this.keys = new LinkedHashSet<>();
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

    public void putKeys(Set<Option> keys) {
        this.keys.addAll(keys);
    }

    public Set<Option> getKeys() {
        return keys;
    }

}
