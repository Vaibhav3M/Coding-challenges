import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static int fibonacci(int n) {

        // time O(n)
        // space O(2n)

        // iterative can be used to reduce space complexity

        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        memoize.put(2, 1);

        return helper(n, memoize);
    }

    private static int helper(int n, Map<Integer, Integer> memoize) {

        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, helper(n - 1, memoize) + helper(n - 2, memoize));
            return memoize.get(n);

        }
    }

    private static int iteratoive_fibonacci(int n) {

        if (n == 0 || n == 1)
            return 0;

        int last = 0;
        int secondlast = 1;

        int counter = 2;

        while (counter <= n) {
            int temp = secondlast + last;
            last = secondlast;
            secondlast = temp;
            counter++;
        }

        return secondlast;
    }

    public static void main(String[] args) {

        // normally time O(2^n)
        // space O(n)

        System.out.println("Memoization = " + fibonacci(10));

        System.out.println("Iterative = " + iteratoive_fibonacci(10));

    }
}
