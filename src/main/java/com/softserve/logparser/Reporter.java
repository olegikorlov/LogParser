package com.softserve.logparser;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface Reporter {

    String buildReport(StatInfo statInfo);

}
