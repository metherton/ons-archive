package com.ethertons;

import static com.ethertons.Factorial.declarativeFactorial;
import static com.ethertons.Factorial.imperativeFactorial;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FactorialTest {

    @Test
    public void testFactorialImperial() throws Exception {
        Long result = imperativeFactorial(3);
        assertThat(result, is(new Long(6)));
    }

    @Test
    public void testFactorialDeclarative() throws Exception {
        Long result = declarativeFactorial(3);
        assertThat(result, is(new Long(6)));
    }

}
