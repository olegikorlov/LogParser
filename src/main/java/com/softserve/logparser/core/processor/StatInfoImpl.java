package com.softserve.logparser.core.processor;

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
