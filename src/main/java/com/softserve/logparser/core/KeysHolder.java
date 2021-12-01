package com.softserve.logparser.core;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface KeysHolder {

    void putKeys(List<String> keys);

    List<String> getKeys();

}
