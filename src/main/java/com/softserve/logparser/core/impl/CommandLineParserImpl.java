package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.CommandLineParser;
import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.parser.option.Option;
import com.softserve.logparser.core.parser.option.OptionParser;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class CommandLineParserImpl implements CommandLineParser {

    @Override
    public boolean parse(String[] strings) {
        if (strings.length < 1) {
            return false;
        }
        LogParserContext context = LogParserContext.getInstance();
        Set<Path> paths = Arrays.stream(strings)
//                .sorted()
                .dropWhile(string -> string.startsWith("-"))
                .map(Path::of)
                .collect(Collectors.toSet());
        context.putPaths(paths);

        List<String> keys = Arrays.stream(strings)
//                .sorted()
                .takeWhile(string -> string.startsWith("-"))
                .collect(Collectors.toList());

        Set<Option> options = Arrays.stream(strings)
                .takeWhile(string -> string.startsWith("-"))
                .map(OptionParser::parse)
                .collect(Collectors.toSet());
        options.forEach(System.out::println);
//        context.putKeys(options);

        context.putKeys(keys);
        return true;
    }

}
