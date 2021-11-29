package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.KeysHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class KeysHolderImpl implements KeysHolder {

    private List<String> keys;

    public KeysHolderImpl() {
        this.keys = new ArrayList<>();
    }

    @Override
    public void put(List<String> keys) {
        this.keys.addAll(keys);
    }

    @Override
    public List<String> getKeys() {
        return keys;
    }

}
