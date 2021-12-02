package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.Reporter;
import com.softserve.logparser.core.StatInfo;

import java.util.function.Consumer;

public final class ReporterImpl implements Reporter {

    private final StatInfo statInfo;

    public ReporterImpl(StatInfo statInfo) {
        this.statInfo = statInfo;
    }

    @Override
    public void buildReport(Consumer<String> out) {
        statInfo.getInfo().forEach((a, b) -> out.accept(String.format("%10s : %s", b, a)));
    }

}
