package com.github.diegov.ideabug;

import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SimpleTest {
    private String line1;

    @Before
    public void setUp() throws IOException {
        ClassLoader c = this.getClass().getClassLoader();
        URL resourceUrl = c.getResource("db/sample.sql");
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(resourceUrl.openStream(), StandardCharsets.UTF_8))) {
            line1 = bufferedReader.readLine();
        }
    }

    @Test
    public void resource_is_read() {
        org.junit.Assert.assertEquals("select * from data_table;", line1);
    }
}
