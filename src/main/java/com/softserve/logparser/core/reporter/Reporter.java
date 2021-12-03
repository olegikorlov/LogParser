package com.softserve.logparser.core.reporter;

import com.softserve.logparser.core.comandline.option.Key;
import com.softserve.logparser.core.comandline.option.Option;
import com.softserve.logparser.core.processor.StatInfo;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Reporter {

    private Reporter() {
        throw new IllegalStateException("Utility class");
    }


    public static void buildReport(StatInfo statInfo, Consumer<String> out) {
        List<Option> temp = statInfo.getInfo();
        StringBuilder description = new StringBuilder();
        switch (temp.get(0).getKey()) {
            case IP -> description.append("Displays the number of requests from IP");
            case RES -> description.append("Displays the number of requests to the site");
            case REF -> description.append("Displays tDisplays statistics by refers");
            case SIZE -> description.append("Displays the correspondence of sites with the amount of data loaded from them");
        }
        if (!temp.get(0).getValue().equals("")) {
            description.append(": ").append(temp.get(0).getValue().replace("*", "..."));
        }
        out.accept(description.toString());
        if (temp.get(0).getKey() != Key.HELP) {
            out.accept(String.format("%-5s : %s", "№", temp.get(0).getKey()));
            out.accept("-------------------------------------");
        }
        statInfo.getData().forEach((a, b) -> out.accept(String.format("%-5s : %s", b, a)));
    }

}
