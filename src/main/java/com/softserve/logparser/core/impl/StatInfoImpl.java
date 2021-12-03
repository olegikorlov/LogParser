package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.StatInfo;

import java.util.List;
import java.util.Map;

public class StatInfoImpl implements StatInfo {

    private final Map<String, Long> data;
    private final List<String> info;

    public StatInfoImpl(Map<String, Long> data, List<String> info) {
        this.data = data;
        this.info = info;
    }

    @Override
    public Map<String, Long> getData() {
        return data;
    }

    @Override
    public List<String> getInfo() {
        return info;
    }
}
