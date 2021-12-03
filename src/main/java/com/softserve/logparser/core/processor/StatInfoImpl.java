package com.softserve.logparser.core.processor;

import com.softserve.logparser.core.comandline.option.Option;

import java.util.List;
import java.util.Map;

public class StatInfoImpl implements StatInfo {

    private final Map<String, Long> data;
    private final List<Option> info;

    public StatInfoImpl(Map<String, Long> data, List<Option> info) {
        this.data = data;
        this.info = info;
    }

    @Override
    public Map<String, Long> getData() {
        return data;
    }

    @Override
    public List<Option> getInfo() {
        return info;
    }
}
