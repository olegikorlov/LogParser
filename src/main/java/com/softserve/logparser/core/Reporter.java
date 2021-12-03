package com.softserve.logparser.core;

import java.util.function.Consumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface Reporter {

    void buildReport(Consumer<String> out);

}
