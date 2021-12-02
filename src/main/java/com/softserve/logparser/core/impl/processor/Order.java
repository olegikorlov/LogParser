package com.softserve.logparser.core.impl.processor;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Order {
    N {
        @Override
        protected Map<String, Long> apply(Map<String, Long> map, int limit) {
            return map
                    .entrySet()
                    .stream()
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    },
    A {
        @Override
        protected Map<String, Long> apply(Map<String, Long> map, int limit) {
            return map
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    },
    D {
        @Override
        protected Map<String, Long> apply(Map<String, Long> map, int limit) {
            return map
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    };

    protected abstract Map<String, Long> apply(Map<String, Long> map, int limit);

}
