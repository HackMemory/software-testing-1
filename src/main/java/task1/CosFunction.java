package task1;

import static java.lang.Float.NaN;

public class CosFunction {
    final static double PRECISION = 0.01;

    public CosFunction() {}

    private static double cosTailor( double val, int n) throws StackOverflowError {
        int sign = (n % 2 == 0) ? 1 : -1;

        return sign * Math.pow(val, 2 * n ) / factorial(2 * n );
    }

    public double cos(double val) {
        val = val % (2 * Math.PI); // переводим угол в диапазон от 0 до 2П

        double result = 1;
        double current = 10;
        double prev = 0;
        int n = 1;
        while (Math.abs(prev - current) >= PRECISION) {
            prev = current;
            current = cosTailor(val, n);
            result += current;
            n++;
        }
        return result;
    }

    private static int factorial(int val) {
        if (val <= 1)
            return 1;
        else
            return val * factorial(val - 1);
    }
}
