package junit.tutorial.rule

import org.junit.Test
import org.junit.Rule
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import org.junit.rules.Timeout
import org.junit.rules.ExpectedException
/*	
 * Rule of Timeout Test
 */
class TimeoutTest {
    @Rule
    public static Timeout timeout = new Timeout(100)
    @Rule
    public static ExpectedException ex = ExpectedException.none()

    @Test 
    void testNotTimeOut() {
      Testee.notTimeOut()
    }

    @Test
    void testNotTimeOutOveride() {
      timeout = new Timeout(1000)
      Testee.timeOut()
    }

    void testTimeoutRuleThanTestAnnotation() {

    }
} 

class Testee {

  static void notTimeOut() {}
  static void timeOut() { Thread.sleep(140)}

}
