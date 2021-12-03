package com.softserve.logparser.core.comandline;

import com.softserve.logparser.core.comandline.option.Option;
import com.softserve.logparser.core.comandline.option.OptionParser;
import com.softserve.logparser.core.context.LogParserContext;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class CommandLineParser {

    private CommandLineParser() {
    }

    public static boolean parse(String[] strings) {
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

        Set<Option> options = Arrays.stream(strings)
                .takeWhile(string -> string.startsWith("-"))
                .map(OptionParser::parse)
                .collect(Collectors.toSet());
//        options.forEach(System.out::println);
        context.putKeys(options);
        return true;
    }

}
