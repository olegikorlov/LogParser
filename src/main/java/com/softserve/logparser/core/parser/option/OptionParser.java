package com.softserve.logparser.core.parser.option;

import java.util.Locale;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class OptionParser {

    private static final String DELIMITER = "=";
    private static final String PREFIX = "-";

    private OptionParser() {
    }

    public static Option parse(String string) {
        String stringWithoutPrefix = string.replaceAll(PREFIX, "");
        if (!stringWithoutPrefix.contains(DELIMITER)) {
            return new Option(Key.valueOf(stringWithoutPrefix.toUpperCase(Locale.ROOT)));
        }
        String[] strings = stringWithoutPrefix.split(DELIMITER);
        return new Option(Key.valueOf(strings[0].toUpperCase(Locale.ROOT)), strings[1]);
    }

}
