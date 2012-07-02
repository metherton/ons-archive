package datastructures2;

import static datastructures2.ListModule.list;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.Option;
import com.ethertons.Some;
import org.junit.Test;

public class ListModuleTest {

    @Test
    public void testVarArgList() throws Exception {
        Option<String> s = new Some<String>("one");
        Option<String> t = new Some<String>("two");
        Option<String> u = new Some<String>("three");

        ListModule.List<String> stringList = list(s, list(t, list(u,  ListModule.<String>emptyList())));
        assertThat(stringList.head().get(), is("one"));
        assertThat(stringList.tail().head().get(), is("two"));
        assertThat(stringList.tail().tail().head().get(), is("three"));
    }
}
