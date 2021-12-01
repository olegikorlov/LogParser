package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.CommandLineParser;
import com.softserve.logparser.core.LogParserContext;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class CommandLineParserImpl implements CommandLineParser {

    private final LogParserContext context;

    public CommandLineParserImpl() {
        this.context = LogParserContextImpl.getInstance();
    }

    @Override
    public boolean parse(String[] strings) {
        if (strings.length < 1) {
            return false;
        }

        List<String> files = Arrays.stream(strings)
//                .sorted()
                .dropWhile(string -> string.startsWith("-"))
                .collect(Collectors.toList());
        context.put(Path.of(files.get(0)));

        List<String> keys = Arrays.stream(strings)
//                .sorted()
                .takeWhile(string -> string.startsWith("-"))
                .collect(Collectors.toList());
        context.put(keys);
        return true;
    }

}
