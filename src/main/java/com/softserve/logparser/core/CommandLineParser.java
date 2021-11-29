package com.softserve.logparser.core;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface CommandLineParser {

    boolean parse(String[] string);

}
