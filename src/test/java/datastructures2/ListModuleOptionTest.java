package datastructures2;

import com.ethertons.Option;
import com.ethertons.Some;
import org.junit.Test;

public class ListModuleOptionTest {

    @Test
    public void headShouldReturnHeadOfList() throws Exception {
        Option<String> red = new Some<String>("red");
        Option<String> blue = new Some<String>("blue");
        Option<String> yellow = new Some<String>("yellow");
      //  ListModuleOption.List<Option> listOptions = list(red, list(blue, list(yellow, emptyList())));
//        listOptions = list(red,null);
        ListModuleOption.list(red, null);
//        assertThat(listOptions.head(), is(red));
    }
}
