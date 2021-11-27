package com.softserve.logparser.core;

import java.util.Map;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface KeysHolder {

    Map<String, Integer> getKeys();

}
