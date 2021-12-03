package com.softserve.logparser.core;

import java.util.List;
import java.util.Map;

public interface StatInfo {
    Map<String, Long> getData();

    List<String> getInfo();
}
