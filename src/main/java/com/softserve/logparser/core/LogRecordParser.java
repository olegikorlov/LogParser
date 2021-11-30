package com.softserve.logparser.core;

import com.softserve.logparser.core.impl.ExtendedLogRecord;

import java.util.Optional;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class LogRecordParser {

    private static final Logger LOGGER = Logger.getLogger(LogRecordParser.class.getName());

    private static final String IP_RGX = "(?<ip>\\S+)";
    private static final String USER_IDENTIFIER_RGX = "(?<identifier>\\S+)";
    private static final String USER_ID_RGX = "(?<userid>\\S+)";
    private static final String TIMESTAMP_RGX = "\\[(?<timestamp>[^\\]]+)\\]";
    private static final String METHOD_RGX = "\"(?<method>[A-Z]+)";
    private static final String REQUEST_RGX = "(?<request>[^ \"]+)";
    private static final String PROTOCOL_RGX = "(?<protocol>HTTP/[0-9.]+)\"";
    private static final String STATUS_RGX = "(?<status>[0-9]{3})";
    private static final String SIZE_RGX = "(?<size>[0-9]+|-)";
    private static final String REFERER_RGX = "\"(?<referrer>[^\"]*)\"";
    private static final String USER_AGENT_RGX = "\"(?<useragent>[^\"]*)\"";

    private LogRecordParser() {
    }

    public static Optional<LogRecord> parse(String string) {
        Matcher matcher = getMatcher(string);
        if (!matcher.find()) {
            String message = String.format("## I couldn't parse this record: %s", string);
            LOGGER.warning(message);
            return Optional.empty();
        }
/*
        for (int i = 1; i <= matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
*/
        return Optional.of(ExtendedLogRecord.builder()
                .ip(matcher.group("ip"))
//                .identifier(matcher.group("identifier"))
//                .userId(matcher.group("userid"))
//                .timestamp(matcher.group("timestamp"))
//                .method(matcher.group("method"))
//                .request(matcher.group("request"))
//                .protocol(matcher.group("protocol"))
//                .timestamp(matcher.group("timestamp"))
//                .status(matcher.group("status"))
//                .size(matcher.group("size"))
//                .referrer(matcher.group("referrer"))
//                .useragent(matcher.group("useragent"))
                .build());
    }

    private static Matcher getMatcher(String string) {
        Pattern pattern = Pattern.compile(
                String.format("^%s %s %s %s " +
                                "%s %s %s %s %s %s %s",
                        IP_RGX, USER_IDENTIFIER_RGX, USER_ID_RGX, TIMESTAMP_RGX,
                        METHOD_RGX, REQUEST_RGX, PROTOCOL_RGX, STATUS_RGX, SIZE_RGX,
                        REFERER_RGX, USER_AGENT_RGX));
        return pattern.matcher(string);
    }

}