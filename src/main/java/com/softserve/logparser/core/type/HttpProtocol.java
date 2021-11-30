package com.softserve.logparser.core.type;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public enum HttpProtocol {

    ERROR("ERROR"),
    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1");

    private final String name;

    HttpProtocol(String name) {
        this.name = name;
    }

    public static HttpProtocol parse(String value) {
        for (HttpProtocol name : HttpProtocol.values()) {
            if (name.getName().equalsIgnoreCase(value)) {
                return name;
            }
        }

        return ERROR;
    }

    public String getName() {
        return name;
    }

}
