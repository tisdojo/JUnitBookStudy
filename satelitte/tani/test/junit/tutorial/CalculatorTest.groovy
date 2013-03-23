package junit.tutorial

import org.junit.Test
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
/*	
 * unit test of {@link Calculator}
 */
class CalculatorTest {

  /**
   * unit test of {@link Calculator#multiply(int, int)} 
   */
  @Test void testMultiply() {
    assertThat(Calculator.multiply(1,1), is(1))
    assertThat(Calculator.multiply(Integer.MAX_VALUE, 2), is(-2))
    assertThat(Calculator.multiply(-4,-1), is(4))
  }
} 
