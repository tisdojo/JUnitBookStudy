package junit.tutorial;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: tenten0213
 * Date: 1/17/13
 * Time: 8:32 AM
 * To change this template use File | Settings | File Templates.
 */


public class CounterTest {

    @Test
    public void testIncrement() throws Exception {
        Counter counter = new Counter();
        assertThat(1,is(counter.increment()));
    }

}
