package com.softserve.logparser.core.reporter;

import com.softserve.logparser.core.processor.StatInfo;

import java.util.function.Consumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Reporter {

    private Reporter() {
    }

    public static void buildReport(StatInfo statInfo, Consumer<String> out) {
        statInfo.getInfo().forEach((a, b) -> out.accept(String.format("%10s : %s", b, a)));
    }

}
