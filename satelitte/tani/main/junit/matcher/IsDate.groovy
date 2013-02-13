package junit.matcher

import org.hamcrest.BaseMatcher
import org.hamcrest.Description

class IsDate extends BaseMatcher<Date> {
	private final int yyyy;
	private final int mm;
	private final int dd;

	IsDate(int yyyy, int mm, int dd) {
	 this.yyyy = yyyy;
	 this.mm = mm;
	 this.dd = dd;
	}

    boolean matches(Object obj) {
    	Date actual = (Date) obj
    	Calendar cal = Calendar.getInstance()
    	cal.setTime(actual)

    	return (yyyy == cal.get(Calendar.YEAR)
           &&   mm   == cal.get(Calendar.MONTH) + 1
           &&   dd  == cal.get(Calendar.DATE))
    }

    void describeTo(Description desc) {

    }

    public static IsDate dateOf(int year, int month, int dayOfMonth) {
        return new IsDate(year, month, dayOfMonth);	
    }

    private static final String EXPRESSION = "%04d/%02d/%02d"
    String toString() {
    	return String.format(EXPRESSION, yyyy,mm,dd)
    }

}