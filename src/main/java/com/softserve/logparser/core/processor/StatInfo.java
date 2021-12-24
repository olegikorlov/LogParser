package com.softserve.logparser.core.processor;

import com.softserve.logparser.core.comandline.option.Option;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StatInfo {

    private final Map<String, Long> data = new LinkedHashMap<>();
    private final List<Option> info = new ArrayList<>();

    public StatInfo(Map<String, Long> data, List<Option> info) {
        this.info.addAll(info);
        this.data.putAll(data);
    }

}
