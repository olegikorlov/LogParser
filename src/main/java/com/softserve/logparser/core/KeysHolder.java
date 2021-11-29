package com.softserve.logparser.core;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface KeysHolder {

    void put(List<String> keys);

    List<String> getKeys();

}
