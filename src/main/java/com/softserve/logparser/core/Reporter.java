package com.softserve.logparser.core;

import java.util.function.Consumer;

@FunctionalInterface
public interface Reporter {

    void buildReport(Consumer<String> out);
}
