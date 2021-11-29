package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.PathHolder;

import java.nio.file.Path;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class PathHolderImpl implements PathHolder {

    private final Path path;

    public PathHolderImpl(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return path;
    }

}
