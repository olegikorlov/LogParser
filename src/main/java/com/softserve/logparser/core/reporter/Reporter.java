package com.softserve.logparser.core.reporter;

import com.softserve.logparser.core.comandline.option.Key;
import com.softserve.logparser.core.comandline.option.Option;
import com.softserve.logparser.core.processor.StatInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Reporter {

    public static void buildReport(StatInfo statInfo, Consumer<String> out) {
        List<Option> temp = statInfo.getInfo();
        String description = "";

        if (temp.get(0).getKey() == Key.IP) {
            description += "Displays the number of requests from IP";
        } else if (temp.get(0).getKey() == Key.RES) {
            description += "Displays the number of requests to the site";
        } else if (temp.get(0).getKey() == Key.REF) {
            description += "Displays tDisplays statistics by refers";
        } else if (temp.get(0).getKey() == Key.SIZE) {
            description += "Displays the correspondence of sites with the amount of data loaded from them";
        }

        if (!temp.get(0).getValue().equals("")) {
            description += String.format(": %s", temp.get(0).getValue().replace("*", "..."));
        }
        out.accept(description);

        if (temp.get(0).getKey() != Key.HELP) {
            out.accept(String.format("%-5s : %s", "№", temp.get(0).getKey()));
            out.accept("-------------------------------------");
        }
        statInfo.getData().forEach((a, b) -> out.accept(String.format("%-5s : %s", b, a)));
    }

}
