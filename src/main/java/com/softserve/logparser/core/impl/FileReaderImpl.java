package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.FileReader;
import com.softserve.logparser.core.LogParserContext;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class FileReaderImpl implements FileReader {

    private final LogParserContext context;

    public FileReaderImpl() {
        this.context = LogParserContextImpl.getInstance();
    }

    @Override
    public Stream<String> read() throws IOException {
        return Files.lines(context.getPath());
    }

}
