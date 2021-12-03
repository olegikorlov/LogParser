package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.Reporter;
import com.softserve.logparser.core.StatInfo;

import java.util.List;
import java.util.function.Consumer;

public final class ReporterImpl implements Reporter {

    private final StatInfo statInfo;

    public ReporterImpl(StatInfo statInfo) {
        this.statInfo = statInfo;
    }

    @Override
    public void buildReport(Consumer<String> out) {
        List<String> temp = statInfo.getInfo();
        StringBuilder description = new StringBuilder();
        switch (temp.get(0)) {
            case "IP" -> description.append("Displays the number of requests from IP");
            case "RES" -> description.append("Displays the number of requests to the site");
            case "SIZE" -> description.append("Displays the correspondence of sites with the amount of data loaded from them");
        }
        if (!temp.get(1).equals("")) {
            description.append(": ").append(temp.get(1).replace("*", "..."));
        }
        switch (temp.get(2)) {
            case "N" -> description.append(" in natural order.");
            case "A" -> description.append(" in ascending order.");
            case "D" -> description.append(" in descending order.");
        }
        out.accept(description.toString());
        out.accept(String.format("%-5s : %s", "№", temp.get(0)));
        out.accept("-------------------------------------");
        statInfo.getData().forEach((a, b) -> out.accept(String.format("%-5s : %s", b, a)));
    }

}
