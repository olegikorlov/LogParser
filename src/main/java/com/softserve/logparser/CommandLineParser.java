package com.softserve.logparser;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface CommandLineParser {

    KeysAndPathHolder parse(String string);

}