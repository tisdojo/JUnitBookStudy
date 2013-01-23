package junit.tutorial.util;

/**
 * Created with IntelliJ IDEA.
 * User: tenten0213
 * Date: 1/10/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {

    public static String toSnakeCase(String text) {
        StringBuilder stb = new StringBuilder(text);
        for (int i = 1; i < text.length(); i++ ) {
            if (!Character.isUpperCase(text.charAt(i))) {
                continue;
            }
            stb.insert(i, '_');
        }
        return stb.toString().toLowerCase();
    }

}
