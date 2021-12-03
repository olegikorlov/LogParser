package com.softserve.logparser.core.filereader;

import com.softserve.logparser.core.context.LogParserContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileReader {

    public static Stream<String> read() {
        LogParserContext context = LogParserContext.getInstance();
        return context.getPaths().parallelStream()
                .flatMap(path -> {
                    try {
                        return Files.lines(path);
                    } catch (IOException e) {
                        log.warning(String.format("File with name %s is absent.", path));
                    }
                    return Stream.empty();
                });
    }

}
