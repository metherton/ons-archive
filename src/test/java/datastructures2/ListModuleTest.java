package datastructures2;

import static org.junit.Assert.assertThat;

import com.ethertons.Option;
import com.ethertons.Some;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ListModuleTest {

    @Test
    public void testVarArgList() throws Exception {
        Option<String> s = new Some<String>("one");
        Option<String> t = new Some<String>("two");
        Option<String> u = new Some<String>("three");

        ListModule.List<String> stringList = ListModule.list(s, ListModule.<String>emptyList());
       // ListModule.List<String> stringList = ListModule.list(s, t, u);
//        assertThat(stringList.head(), Matchers.is("three"));
        assertThat(stringList.head().get(), Matchers.is("one"));
    }
}
