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

	private static Date dateWith(int year, int month, int dayOfMonth) {
		return new GregorianCalendar(year, month - 1, dayOfMonth).getTime();
	}
} 
