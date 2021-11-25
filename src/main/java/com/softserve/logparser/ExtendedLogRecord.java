package com.softserve.logparser;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class ExtendedLogRecord implements LogRecord {

    @Override
    public String getIP() {
        return null;
    }

    @Override
    public String getAuth() {
        return null;
    }

    @Override
    public LocalDateTime getTimeStamp() {
        return null;
    }

    @Override
    public HttpMethod getMethod() {
        return null;
    }

    @Override
    public String getResource() {
        return null;
    }

    @Override
    public HttpProtocol getProtocol() {
        return null;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public Long getSize() {
        return null;
    }

    @Override
    public String getReferrer() {
        return null;
    }

    @Override
    public String getUserAgent() {
        return null;
    }

}
