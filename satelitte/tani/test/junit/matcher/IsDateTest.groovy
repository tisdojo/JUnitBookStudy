package junit.matcher

import org.hamcrest.Description
import java.util.Date
import org.junit.Test
import org.junit.Ignore
import static org.junit.Assert.*
import static junit.matcher.IsDate.dateOf

/**
 * {@link IsDate}のてすと。
 */
class IsDateTest {

	@Test void testMactched() {
		IsDate matcher = dateOf(1999, 1, 1)
		assertTrue("unmateched!!", matcher.matches(dateWith(1999, 1, 1)))
	}

	@Test void testUnmathcedYear() {
		Date beforeYear = dateWith(1998, 1, 1)
		IsDate matcher =  dateOf(1999, 1, 1)
		Date afterYear = dateWith(2000, 1, 1)
		assertFalse('matched before year', matcher.matches(beforeYear))
		assertFalse('matched after  year', matcher.matches(afterYear))
	}

	@Test void testUnmathcedMonth() {
		Date beforeMonth = dateWith(1999, 1, 1)
		IsDate matcher = dateOf(1999, 2, 1)
		Date afterMonth = dateWith(1999, 3, 1)

		assertFalse('matched before month', matcher.matches(beforeMonth));
		assertFalse('matched before month', matcher.matches(afterMonth))
	}

	@Test void testUnmathcedDay() {
		Date beforeDay = dateWith(1999, 1, 1)
		IsDate matcher = dateOf(1999, 1, 2)
		Date afterDay = dateWith(1999, 1, 3)

		assertFalse(matcher.matches(beforeDay))
		assertFalse(matcher.matches(afterDay))
	}

	@Test void testTypeSafe() {
       UnkownType typeTest = new UnkownType()
       IsDate matcher = dateOf(1999, 1, 1)
       assertFalse(matcher.matches(typeTest))

	}
	
	private static class UnkownType{
		String toString() {
			return "UnkownType object."
		}
	}
	
	@Test void testNullSafe() {
		IsDate matcher = dateOf(1999, 1, 1)
		assertFalse(matcher.matches(null))
	}

	@Test void testDescription() {
		try {
			assertThat(dateWith(1998, 1, 1), dateOf(1999, 1, 1))
			fail('test not failed')
		} catch (AssertionError e) {
			assertEquals("unmathced description.", e.getMessage(), "\nExpected: 1999/01/01 but actual is 1998/01/01\n     got: <Thu Jan 01 00:00:00 JST 1998>\n")
		}
	}

	@Test void testDescriptionNullValue() {
		try {
			assertThat(null, dateOf(1999, 1, 1))
			fail('test not failed')
		} catch (AssertionError e) {
		    assertEquals("null value description.", e.getMessage(), "\nExpected: 1999/01/01\n     got: null\n")
        }	
	}

	@Test void testDescriptionUnmatchedType() {
		try {
			assertThat(new UnkownType(), dateOf(1999,1,1))
			fail('test not failed')
		} catch (AssertionError e) {
			assertEquals('unmathced type description', e.getMessage(), "\nExpected: 1999/01/01\n     got: <UnkownType object.>\n")
		}

	}

	@Test
	@Ignore void testNullValueDescription() {
		try {
			assertThat(null, dateOf(1999, 1, 2))
		} catch (AssertionError e) {

		}
	}

	private static Date dateWith(int year, int month, int dayOfMonth) {
		return new GregorianCalendar(year, month - 1, dayOfMonth).getTime();
	}
} 
