package com.softserve.logparser.core.comandline.option;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class Option {

    private final Key key;

    @EqualsAndHashCode.Exclude
    private final String value;

    public Option(Key key) {
        this(key, "");
    }

}
