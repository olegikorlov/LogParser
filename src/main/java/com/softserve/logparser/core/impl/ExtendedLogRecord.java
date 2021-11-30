package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.type.HttpMethod;
import com.softserve.logparser.core.type.HttpProtocol;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class ExtendedLogRecord implements LogRecord {

    private final String ip;

    private ExtendedLogRecord(Builder builder) {
        this.ip = builder.ip;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String ip;

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public ExtendedLogRecord build() {
            return new ExtendedLogRecord(this);
        }

    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExtendedLogRecord{");
        sb.append("ip='").append(ip).append('\'');
        sb.append('}');
        return sb.toString();
    }
}