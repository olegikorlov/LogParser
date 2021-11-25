package com.softserve.logparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class FileReaderImpl implements FileReader {

    @Override
    public Stream<String> read(PathHolder path) throws IOException {
        return Files.lines(Paths.get(path.getPath()));
    }

}
