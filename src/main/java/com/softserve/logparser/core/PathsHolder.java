package com.softserve.logparser.core;

import java.nio.file.Path;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface PathsHolder {

    void putPaths(Set<Path> paths);

    Set<Path> getPaths();

}
