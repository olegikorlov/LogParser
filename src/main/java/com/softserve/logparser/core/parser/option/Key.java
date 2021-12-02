package com.softserve.logparser.core.parser.option;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public enum Key {

    TOP(OptionType.METHOD),
    IP(OptionType.IDENTIFIER),
    RES(OptionType.IDENTIFIER),
    REF(OptionType.IDENTIFIER); // old SC

    private OptionType type;

    Key(OptionType type) {
        this.type = type;
    }

    public OptionType getType() {
        return type;
    }

}
