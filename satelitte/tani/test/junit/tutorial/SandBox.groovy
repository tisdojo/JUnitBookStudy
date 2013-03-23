package junit.tutorial

import org.junit.Test
import static org.junit.Assert.*
import static org.junit.matchers.JUnitMatchers.*
import static org.hamcrest.CoreMatchers.*
import org.junit.experimental.theories.Theories
import org.junit.runner.RunWith
/*	
 * unit test of {@link Calculator}
 */
class CalculatorTest {

  @Test void testCountUp() {
    assert SandBox.countUp(1,2,1) == [1,2]
    assert SandBox.countUp(1,2,2) == [2]
  }


  class SandBox {
    /**
     * number array that start to end number.
     * if multiples larger than 1, numbers are multiples.
     * multiples must not be 0 or less that.
     */
    static List countUp(int start, int end, int multiples) {
      List list = []
      for (int num = start * multiples; end >= num; num=num+multiples){
        list.add(num)
      }
      return list
    }

  }

} 
