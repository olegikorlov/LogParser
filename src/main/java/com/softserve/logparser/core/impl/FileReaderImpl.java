package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.FileReader;
import com.softserve.logparser.core.PathHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class FileReaderImpl implements FileReader {

    private final PathHolder pathHolder;

    public FileReaderImpl() {
        this.pathHolder = LogParserContextImpl.getInstance().getPathHolder();
    }

    @Override
    public Stream<String> read() throws IOException {
        return Files.lines(Paths.get(pathHolder.getPath()));
    }

}
