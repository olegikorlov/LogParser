package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;

import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class KeysHolderImpl implements KeysHolder {

    private final List<String> keys;

    public KeysHolderImpl(List<String> keys) {
        this.keys = keys;
    }

    @Override
    public List<String> getKeys() {
        return keys;
    }

}
