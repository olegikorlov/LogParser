package com.softserve.logparser.core.logrecord;

import java.time.ZonedDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface LogRecord {

    String getIP();

    String getIdentifier();

    String getUserId();

    ZonedDateTime getTimeStamp();

    HttpMethod getMethod();

    String getResource();

    HttpProtocol getProtocol();

    int getStatusCode();

    Long getSize();

    String getReferrer();

    String getUserAgent();

}
