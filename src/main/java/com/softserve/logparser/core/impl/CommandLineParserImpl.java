package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.CommandLineParser;
import com.softserve.logparser.core.LogParserContext;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public final class CommandLineParserImpl implements CommandLineParser {

    @Override
    public boolean parse(String[] strings) {
        if (strings.length < 1) {
            return false;
        }
        LogParserContext context = LogParserContext.getInstance();
        Set<Path> paths = Arrays.stream(strings)
                .dropWhile(string -> string.startsWith("-"))
                .map(Path::of)
                .collect(Collectors.toSet());
        context.putPaths(paths);

        List<String> keys = Arrays.stream(strings)
                .takeWhile(string -> string.startsWith("-"))
                .collect(Collectors.toList());

        Map<String, String> keysMap = new LinkedHashMap<>();

        for (var i : keys) {
            String[] temp = i.split("=");
            String arg = "";
            if (temp.length == 2) {
                arg = temp[1];
            }
            keysMap.merge(temp[0].replace("-", "").toUpperCase(), arg, (a, b) -> b);
        }

        context.putKeys(keysMap);
        return true;
    }

}
