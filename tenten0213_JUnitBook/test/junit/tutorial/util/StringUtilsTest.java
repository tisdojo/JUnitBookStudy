package junit.tutorial.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created with IntelliJ IDEA.
 * User: tenten0213
 * Date: 1/10/13
 * Time: 8:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {
    @Test
    public void toSnakeCase_aaa() throws Exception {
        assertThat (StringUtils.toSnakeCase("aaa"), is("aaa"));
    }

    @Test
    public void toSnakeCase_HelloWorld() throws Exception {
        assertThat (StringUtils.toSnakeCase("HelloWorld"), is("hello_world"));
    }

    @Test
    public void toSnakeCase_practiceJunit() throws Exception {
        assertThat (StringUtils.toSnakeCase("practiceJunit"), is("practice_junit"));
    }

    @Test(expected = NullPointerException.class)
    public void toSnakeCase_null() throws Exception {
        StringUtils.toSnakeCase(null);
    }

    @Test
    public void toSnakeCase_notAlphabet() throws Exception {
        assertThat (StringUtils.toSnakeCase("あｱ4$"), is("あｱ4$"));
    }

    @Test
    public void toSnakeCase_mixedAlphabet() throws Exception {
        assertThat (StringUtils.toSnakeCase("あｱA4$"), is("あｱ_a4$"));
    }
}
