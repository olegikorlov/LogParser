package com.softserve.logparser.core.impl.processor;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Method {
    TOP {
        @Override
        protected Map<String, Long> apply(Stream<String> stream, int methodArg) {
            return stream
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(methodArg)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    },
    TAIL {
        @Override
        protected Map<String, Long> apply(Stream<String> stream, int methodArg) {
            return stream
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .limit(methodArg)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    };

    protected abstract Map<String, Long> apply(Stream<String> stream, int methodArg);

}
