package com.softserve.logparser.core;

import com.softserve.logparser.core.type.HttpMethod;
import com.softserve.logparser.core.type.HttpProtocol;

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
