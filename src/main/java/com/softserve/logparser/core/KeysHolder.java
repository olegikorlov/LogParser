package com.softserve.logparser.core;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@FunctionalInterface
public interface KeysHolder {

    List<String> getKeys();

}
