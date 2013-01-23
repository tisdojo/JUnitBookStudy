package junit.tutorial;

/**
 * Created with IntelliJ IDEA.
 * User: tenten0213
 * Date: 1/10/13
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public int multiply(int x, int y) {
        return x * y;
    }

    public float divideWithFloat(float x, float y) {
        return x / y;
    }

    public int divideWithInt(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0除算です。");
        }
        return x / y;
    }
}
