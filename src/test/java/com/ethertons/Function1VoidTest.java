package com.ethertons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Function1VoidTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private String test;

    Function1Void<String> f = new Function1Void<String>() {
        public void apply(String name) {
            test = "hello " + name;
        }};

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testFunction1VoidPrintsNameCorrectly() {
        String[] names = {"John", "Mike"};
        for (String name : names) {
            f.apply(name);
            assertEquals("hello " + name, test);
        }
    }

//    @Test
//    public void testFunction1VoidPrintsNameCorrectly() {
//        String[] names = {"John", "Mike"};
//        for (String name : names) {
//            invokeCallback1Void( new Function1Void<String>() {
//                public void apply(String name) {
//                    test = "hello " + name;
//                }
//            }, name);
//            assertEquals("hello " + name, test);
//        }
//    }

    private void invokeCallback1Void(Function1Void<String> f, String name) {
        f.apply(name);
    }

}
