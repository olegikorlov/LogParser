package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.StatInfo;

import java.util.Map;

public class StatInfoImpl implements StatInfo {

    private final Map<String, Long> map;

    public StatInfoImpl(Map<String, Long> map) {
        this.map = map;
    }

    @Override
    public Map<String, Long> getInfo() {
        return map;
    }
}
