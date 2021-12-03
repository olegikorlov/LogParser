package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.LogRecord;
import com.softserve.logparser.core.type.HttpMethod;
import com.softserve.logparser.core.type.HttpProtocol;

import java.time.ZonedDateTime;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class ExtendedLogRecord implements LogRecord {
    private String ip;
    private String identifier;
    private String userId;
    private ZonedDateTime timeStamp;
    private HttpMethod method;
    private String resource;
    private HttpProtocol protocol;
    private int statusCode;
    private long size;
    private String referrer;
    private String userAgent;

    private ExtendedLogRecord(Builder builder) {
        this.ip = builder.ip;
        this.identifier = builder.identifier;
        this.userId = builder.userId;
        this.timeStamp = builder.timeStamp;
        this.method = builder.method;
        this.resource = builder.resource;
        this.protocol = builder.protocol;
        this.statusCode = builder.statusCode;
        this.size = builder.size;
        this.referrer = builder.referrer;
        this.userAgent = builder.userAgent;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getIP() {
        return ip;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public String getResource() {
        return resource;
    }

    @Override
    public HttpProtocol getProtocol() {
        return protocol;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public Long getSize() {
        return size;
    }

    @Override
    public String getReferrer() {
        return referrer;
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExtendedLogRecord{");
        sb.append("ip='").append(ip).append('\'');
        sb.append("identifier='").append(identifier).append('\'');
        sb.append("userId='").append(userId).append('\'');
        sb.append("timeStamp='").append(timeStamp).append('\'');
        sb.append("method='").append(method).append('\'');
        sb.append("resource='").append(resource).append('\'');
        sb.append("protocol='").append(protocol).append('\'');
        sb.append("statusCode='").append(statusCode).append('\'');
        sb.append("size='").append(size).append('\'');
        sb.append("referer='").append(referrer).append('\'');
        sb.append("userAgent='").append(userAgent).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private String ip;
        private String identifier;
        private String userId;
        private ZonedDateTime timeStamp;
        private HttpMethod method;
        private String resource;
        private HttpProtocol protocol;
        private int statusCode;
        private long size;
        private String referrer;
        private String userAgent;

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder timestamp(ZonedDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        public Builder resource(String resource) {
            this.resource = resource;
            return this;
        }

        public Builder protocol(HttpProtocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder size(long size) {
            this.size = size;
            return this;
        }

        public Builder referrer(String referrer) {
            this.referrer = referrer;
            return this;
        }

        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public ExtendedLogRecord build() {
            return new ExtendedLogRecord(this);
        }
    }

}