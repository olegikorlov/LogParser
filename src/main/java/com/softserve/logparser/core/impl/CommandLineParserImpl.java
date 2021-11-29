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

    private LogParserContext context;

    public CommandLineParserImpl() {
        this.context = LogParserContextImpl.getInstance();
    }

    @Override
    public boolean parse(String string) {
        String[] strings = string.split(" ");
        if (strings.length < 1) {
            return false;
        }
        System.out.println(strings[0]);
        context.put(Path.of(strings[0]));

        List<String> keys = Arrays.stream(strings)
                .skip(1)
                .collect(Collectors.toList());
        context.put(keys);
        return true;
    }

}
