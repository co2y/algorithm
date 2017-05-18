package classic;

/**
 * Created by co2y on 04/04/2017.
 */
public class QuickPow {
    public static final int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        long a = 100;
        System.out.print(quickPow(a, mod - 2));
    }

    private static long quickPow(long a, int b) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = a * res % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
