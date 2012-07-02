import com.ethertons.Display;
import com.ethertons.None;
import com.ethertons.Some;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DisplayTest {

    @Test
    public void testDisplay() throws Exception {
        Display d = new Display(new Some<String>("Hello world"));
        Assert.assertThat(d.show(), Matchers.is("Hello world"));
    }

    @Test
    public void testDisplayShowsDefault() throws Exception {
        Display d = new Display(new None<String>());
        Assert.assertThat(d.show(), Matchers.is("default"));
    }

}

