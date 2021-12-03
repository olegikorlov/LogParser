package com.softserve.logparser.core.processor;

import com.softserve.logparser.core.comandline.option.Option;

import java.util.List;
import java.util.Map;

public interface StatInfo {
    List<Option> getInfo();

    Map<String, Long> getData();
}
