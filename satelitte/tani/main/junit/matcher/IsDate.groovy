package junit.matcher

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import java.text.SimpleDateFormat

/**
 * Date Mather.
 */
class IsDate extends BaseMatcher<Date> {
    private final int yyyy;
    private final int mm;
    private final int dd;
    private Object actual;
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * use creation method {@link dateOf(int, int, int)}
     */
    private IsDate(int yyyy, int mm, int dd) {
      this.yyyy = yyyy;
      this.mm = mm;
      this.dd = dd;
    }

    @Override
    boolean matches(Object obj) {
        actual = obj;
        if (!(obj instanceof Date)) {
            return false;
        }
        Date actual = (Date) obj
        Calendar cal = Calendar.getInstance()
        cal.setTime(actual)

        return (yyyy == cal.get(Calendar.YEAR)
           &&   mm   == cal.get(Calendar.MONTH) + 1
           &&   dd  == cal.get(Calendar.DATE))
    }

    @Override
    void describeTo(Description desc) {
        desc.appendText(this.toString()
                        + getActualExpression())
    }

    /**
     * return expression of actual date.
     * if actual is null or unmached type
     * return empty string. 
     * @return actual expression 
     */
    private String getActualExpression() {
        if (actual instanceof Date){
            return " but actual is " + DATE_FORMAT.format(actual);
        }
        return "";
    }

    public static IsDate dateOf(int year, int month, int dayOfMonth) {
        return new IsDate(year, month, dayOfMonth);    
    }

    String toString() {
        return String.format("%04d/%02d/%02d", yyyy,mm,dd)
    }

}