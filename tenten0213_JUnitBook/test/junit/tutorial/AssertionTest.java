package junit.tutorial;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertionTest {
    @Test
    public void assertionTest() {
        String actual = "Hello" + " " + "World";
        assertThat(actual, is("Hello World"));
    }
    @Test
    public void なにか難しいけど重要なテストケース() {
        fail("TODO テストコードを実装する");
    }
    @Test(expected = IllegalStateException.class)
    public void timeoutがtrueの時にロジックが実行されないこと(){
        //setup
        Runnable logic = new Runnable() {
            public void run() {
                fail("runが呼ばれてしまった");
            }
        };

    }
}
