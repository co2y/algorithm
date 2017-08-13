package baidu;

import java.util.Scanner;

/**
 * Created by co2y on 2017/8/13.
 */
public class CLucas {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();

            if (n > m) {
                System.out.println(Lucas(n, m));
            } else
                System.out.println(Lucas(m, n));


        }
    }

    static long quick_mod(long a, long b) {
        long ans = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
                b--;
            }
            b >>= 1;
            a = a * a % MOD;
        }
        return ans;
    }

    static long C(long n, long m) {
        if (m > n) return 0;
        long ans = 1;
        for (int i = 1; i <= m; i++) {
            long a = (n + i - m) % MOD;
            long b = i % MOD;
            ans = ans * (a * quick_mod(b, MOD - 2) % MOD) % MOD;
        }
        return ans;
    }

    static long Lucas(long n, long m) {
        if (m == 0) return 1;
        return C(n % MOD, m % MOD) * Lucas(n / MOD, m / MOD) % MOD;
    }
}
