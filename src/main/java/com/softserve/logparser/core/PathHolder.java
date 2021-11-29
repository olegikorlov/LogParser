package com.softserve.logparser.core;

import java.nio.file.Path;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface PathHolder {

    Path getPath();

}
