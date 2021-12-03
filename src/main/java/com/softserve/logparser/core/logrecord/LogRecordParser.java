package com.softserve.logparser.core.logrecord;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogRecordParser {

    private static final String IP_RGX = "(?<ip>\\S+)";
    private static final String USER_IDENTIFIER_RGX = "(?<identifier>\\S+)";
    private static final String USER_ID_RGX = "(?<userid>\\S+)";
    private static final String TIMESTAMP_RGX = "\\[(?<timestamp>[^\\]]+)\\]";
    private static final String METHOD_RGX = "\"(?<method>[A-Z]+)";
    private static final String REQUEST_RGX = "(?<resource>[^ \"]+)";
    private static final String PROTOCOL_RGX = "(?<protocol>HTTP/[0-9.]+)\"";
    private static final String STATUS_RGX = "(?<status>[0-9]{3})";
    private static final String SIZE_RGX = "(?<size>[0-9]+|-)";
    private static final String REFERER_RGX = "\"(?<referrer>[^\"]*)\"";
    private static final String USER_AGENT_RGX = "\"(?<useragent>[^\"]*)\"";
    private static final Pattern PATTERN = Pattern.compile(
            String.format("^%s %s %s %s " +
                            "%s %s %s %s %s %s %s",
                    IP_RGX, USER_IDENTIFIER_RGX, USER_ID_RGX, TIMESTAMP_RGX,
                    METHOD_RGX, REQUEST_RGX, PROTOCOL_RGX, STATUS_RGX, SIZE_RGX,
                    REFERER_RGX, USER_AGENT_RGX));

    public static Optional<ExtendedLogRecord> parse(String string) {
        Matcher matcher = PATTERN.matcher(string);
        if (!matcher.find()) {
            String message = String.format("## I couldn't parse this record: %s", string);
            log.warning(message);
            return Optional.empty();
        }

        try {
            String timestamp = matcher.group("timestamp");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.US);
            ZonedDateTime dateTime = ZonedDateTime.parse(timestamp, formatter);
            String size = matcher.group("size");
            return Optional.of(ExtendedLogRecord.builder()
                    .ip(matcher.group("ip"))
                    .identifier(matcher.group("identifier"))
                    .userId(matcher.group("userid"))
                    .timeStamp(dateTime)
                    .method(HttpMethod.valueOf(matcher.group("method")))
                    .resource(matcher.group("resource"))
                    .protocol(HttpProtocol.parse(matcher.group("protocol")))
                    .statusCode(Integer.parseInt(matcher.group("status")))
                    .size(Long.parseLong(size.equals("-") ? "0" : size))
                    .referrer(matcher.group("referrer"))
                    .userAgent(matcher.group("useragent"))
                    .build());
        } catch (Exception e) {
            String msg = String.format("## Can't read this log record: %s%nstack trace: %s", string, e.getMessage());
            log.warning(msg);
            return Optional.empty();
        }
    }

}