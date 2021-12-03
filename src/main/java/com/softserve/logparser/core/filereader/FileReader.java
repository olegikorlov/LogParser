package com.softserve.logparser.core.filereader;

import com.softserve.logparser.core.context.LogParserContext;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class FileReader {

    public static Stream<String> read() {
        LogParserContext context = LogParserContext.getInstance();
        return context.getPaths().stream()
                .flatMap(path -> {
                    try {
                        return Files.lines(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Stream.empty();
                });
    }

}
