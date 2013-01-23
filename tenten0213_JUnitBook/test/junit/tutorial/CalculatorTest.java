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
    public void divideWithFloatで3と2の除算結果が取得できること() throws Exception {
        Calculator calc = new Calculator();
        float expected = 1.5f;
        float actual = calc.divideWithFloat(3,2);
        assertThat(actual,is(expected));
    }

    @Test
    public void divideWithIntで3と2の除算結果が取得できること() throws Exception {
        Calculator calc = new Calculator();
        int expected = 1;
        int actual = calc.divideWithInt(3,2);
        assertThat(actual,is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideWithIntの第2引数に0を指定すると例外が発生する() throws Exception {
        Calculator calc = new Calculator();
        calc.divideWithInt(3,0);
    }
}
