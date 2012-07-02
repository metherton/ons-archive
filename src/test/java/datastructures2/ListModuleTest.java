package datastructures2;

import static datastructures2.ListModule.list;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.None;
import com.ethertons.Option;
import com.ethertons.Some;
import org.junit.Test;

public class ListModuleTest {

    @Test
    public void testVarArgList() throws Exception {
        Option<String> head = new Some<String>("one");
        Option<String> t = new Some<String>("two");
        Option<String> u = new Some<String>("three");
        ListModule.List<String> tail = list(t, list(u, ListModule.<String>emptyList()));

        Option<ListModule.List<String>> tailOption = new Some<ListModule.List<String>>(tail);

        ListModule.List<String> stringList = list(head, tail);
        assertThat(stringList.head().get(), is("one"));
        assertThat(stringList.tail().get(), is(tailOption.get()));
    }

    @Test
    public void emptyListHeadAndTailShouldNotThrowException() throws Exception {
        ListModule.List<String> stringList = list(new None<String>(), ListModule.<String>emptyList());
        assertThat(stringList.head().getOrElse("empty"), is("empty"));
    }
}
