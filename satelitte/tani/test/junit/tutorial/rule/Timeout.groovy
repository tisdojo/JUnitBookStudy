package junit.tutorial.rule

import org.junit.Test
import org.junit.Rule
import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import org.junit.rules.Timeout
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.junit.experimental.runners.Enclosed
/*	
 * Rule of Timeout Test
 */
class TimeoutTest {
    @Test 
    void testNotTimeOut() {
      Testee.notTimeOut()
    }

    @Rule
    public static Timeout timeout = new Timeout(100)
    @Rule
    public static ExpectedException exception = ExpectedException.none()

    @Test(timeout = 500L)
    void testTimeOutRuleCanNotOverrideOnTestAnnotate() {
      exception.expect(Exception.class)
      exception.expectMessage("test timed out after 100 milliseconds")
      Testee.timeOut()
    }

    @Test
    void testTimeOutRuleCanNotOverideInnerSetup() {
      timeout = new Timeout(1000)
      exception.expect(Exception.class)
      exception.expectMessage("test timed out after 100 milliseconds")
      Testee.timeOut()
    }

    
} 

class Testee {

  static void notTimeOut() {}
  static void timeOut() { Thread.sleep(140)}

}
