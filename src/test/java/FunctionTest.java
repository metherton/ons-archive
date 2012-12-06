import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ethertons.RecursiveAdder;
import com.google.common.collect.Lists;

import functions.Function1;
import functions.Function1Void;
import functions.Function2;

public class FunctionTest {

    static boolean changeMe = false;

    @Before
    public void setUp() {
        changeMe = false;
    }

    private void invokeFunction1Void(Function1Void<String> function1Void) {
        function1Void.apply("hello");
    }

    @Test
    public void testFunction1Void() throws Exception {
        
        invokeFunction1Void(new Function1Void<String>() {
            @Override
            public void apply(String s) {
                changeMe = true;
            }
        });
        Assert.assertTrue(changeMe);

    }

    private Object invokeFunction1(Function1<? super String, ? extends Object> function1) {
        return function1.apply("hello");
    }

    private Boolean invokeFunction2(Function2<String, Integer, Boolean> function2) {
        return function2.apply("hello", 2);
    }

    @Test
    public void testFunction2() throws Exception {
        changeMe = invokeFunction2(new Function2<String, Integer, Boolean>() {
            @Override
            public Boolean apply(String s, Integer integer) {
                return true;
            }
        });
        Assert.assertTrue(changeMe);
    }

    @Test
    public void testRecursiveMethodToAddAListOfNumbers() throws Exception {
        List<Integer> listOfNumbers = Lists.newArrayList(1,2,3,4,5);
        assertThat(RecursiveAdder.add(listOfNumbers), Matchers.is(15));
    }

    @Test
    public void testFunction1() throws Exception {
        invokeFunction1(new Function1<String, String>() {
            @Override
            public String apply(String a) {
                return null;
            }

        });
    }

}
