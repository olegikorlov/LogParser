package com.softserve.logparser;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public enum HttpProtocol {

    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1");

    private final String name;

    HttpProtocol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
