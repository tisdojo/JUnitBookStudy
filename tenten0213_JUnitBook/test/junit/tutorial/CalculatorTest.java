package junit.tutorial;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: tenten0213
 * Date: 1/10/13
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    @Test
    public void testMultiply() throws Exception {
        Calculator calc = new Calculator();
        int expected = 12;
        int actual = calc.multiply(3,4);
        assertThat(actual, is(expected));
    }

    @Test
    public void testDivide() throws Exception {
        Calculator calc = new Calculator();
        float expected = 1.5f;
        float actual = calc.divide(3,2);
        assertThat(actual,is(expected));

    }
}
