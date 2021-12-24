package com.softserve.logparser.core.logrecord;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Getter
@Builder
@ToString
public class ExtendedLogRecord {

    private final String ip;
    private final String identifier;
    private final String userId;
    private final ZonedDateTime timeStamp;
    private final HttpMethod method;
    private final String resource;
    private final HttpProtocol protocol;
    private final int statusCode;
    private final long size;
    private final String referrer;
    private final String userAgent;

}
