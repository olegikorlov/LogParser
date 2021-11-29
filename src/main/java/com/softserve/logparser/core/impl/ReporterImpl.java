package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.Reporter;
import com.softserve.logparser.core.StatInfo;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class ReporterImpl implements Reporter {

    private final StatInfo statInfo;

    public ReporterImpl(StatInfo statInfo) {
        this.statInfo = statInfo;
    }

    @Override
    public String buildReport() {
        return null;
    }

}
