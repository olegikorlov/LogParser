package com.softserve.logparser.core.impl;

import com.softserve.logparser.core.CommandLineParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CommandLineParserImplTest {

    @DisplayName("False")
    @Test
    void test1() {
        var zero = new String[0];
        CommandLineParser cliParser = new CommandLineParserImpl();
        assertFalse(cliParser.parse(zero));
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"apache_logs.txt"}),
                Arguments.of((Object) new String[]{"-sc=2xx -d apache_logs.txt"}),
                Arguments.of((Object) new String[]{"-ip -l=10 -a apache_logs_1.txt apache_logs_2.txt"}),
                Arguments.of((Object) new String[]{"-size -l=30 -from=2016-02-14T18:00:00 apache_logs_1.txt"})

        );
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    void testWithParameters(String[] input) {
        CommandLineParser cliParser = new CommandLineParserImpl();
        assertTrue(cliParser.parse(input));
    }


}
