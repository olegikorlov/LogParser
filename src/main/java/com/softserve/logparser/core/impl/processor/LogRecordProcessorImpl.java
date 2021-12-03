package com.softserve.logparser.core.impl.processor;

import com.softserve.logparser.core.LogParserContext;
import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.LogRecordProcessor;
import com.softserve.logparser.core.StatInfo;
import com.softserve.logparser.core.impl.StatInfoImpl;

import java.util.List;
import java.util.stream.Stream;

public final class LogRecordProcessorImpl implements LogRecordProcessor {

    @Override
    public StatInfo process(Stream<LogRecord> logRecordStream) {
        LogParserContext context = LogParserContext.getInstance();
        List<String> keys = context.getKeys();

        String[] temp = keys.get(0).replace("-", "").split("=");
        int methodArg = Integer.MAX_VALUE;
        Method method = Method.valueOf(temp[0].toUpperCase());
        if (temp.length == 2) {
            methodArg = Integer.parseInt(temp[1]);
        }

        temp = keys.get(1).replace("-", "").split("=");
        String identifierArg = ".*";
        Identifier identifier = Identifier.valueOf(temp[0].toUpperCase());
        if (temp.length == 2) {
            identifierArg = temp[1];
        }
        return new StatInfoImpl(method.apply(identifier.apply(logRecordStream, identifierArg), methodArg));
    }
}
