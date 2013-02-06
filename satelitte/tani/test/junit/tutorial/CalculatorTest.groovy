package junit.tutorial

import org.junit.Test
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*

/*	
 * unit test of {@link Calculator}
 */
class CalculatorTest {

  @Test void testMultiply() {
  	Calculator testee = new Calculator();
    assertThat(testee.multiply(1,1), is(1))
    assertThat(testee.multiply(Integer.MAX_VALUE, 2), is(-2))
  }

} 

