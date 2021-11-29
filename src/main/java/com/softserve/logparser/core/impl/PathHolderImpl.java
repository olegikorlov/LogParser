package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.PathHolder;

import java.nio.file.Path;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class PathHolderImpl implements PathHolder {

    private Path path;

    public PathHolderImpl() {
        this.path = Path.of("");
    }

    @Override
    public void put(Path path) {
        this.path = path;
    }

    @Override
    public Path getPath() {
        return path;
    }

}
