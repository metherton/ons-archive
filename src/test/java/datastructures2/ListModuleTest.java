package datastructures2;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class ListModuleTest {

    @Test
    public void testVarArgList() throws Exception {
        String s = "one";
        String t = "two";
        String u = "three";

        ListModule.List<String> stringList = ListModule.list(s, t, u);
        assertThat(stringList.head(), Matchers.is("three"));
    }
}
