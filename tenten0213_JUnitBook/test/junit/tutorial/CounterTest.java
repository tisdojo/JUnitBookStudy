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
    public void 初期状態でincrementメソッドを実行すると1が取得できる() throws Exception {
        Counter counter = new Counter();
        assertThat(counter.increment(),is(1));
    }

    @Test
    public void incrementメソッドを1回実行した状態でincrementメソッドを実行すると2が取得できる() throws Exception {
        Counter counter = new Counter();
        counter.increment();
        assertThat(counter.increment(),is(2));
    }

    @Test
    public void incrementメソッドを50回実行した状態でincrementメソッドを実行すると51が取得できる() throws Exception {
        Counter counter = new Counter();
        for (int i = 0; i < 50; i++) {
            counter.increment();
        }
        assertThat(counter.increment(),is(51));
    }

}
