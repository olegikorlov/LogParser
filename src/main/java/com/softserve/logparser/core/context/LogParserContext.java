package com.softserve.logparser.core.context;

import com.softserve.logparser.core.comandline.option.Option;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogParserContext {

    private static LogParserContext instance;
    private final Set<Path> paths = new HashSet<>();
    private final Set<Option> keys = new LinkedHashSet<>();

    public static LogParserContext getInstance() {
        if (instance == null) {
            instance = new LogParserContext();
        }
        return instance;
    }

    public void putPaths(Set<Path> paths) {
        this.paths.addAll(paths);
    }

    public void putKeys(Set<Option> keys) {
        this.keys.addAll(keys);
    }

}
