package hihocoder9;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by co2y on 12/03/2017.
 */
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger ans = BigInteger.valueOf(1);
        for (int i = 1; i <= n*m; ++i) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        BigInteger bns = BigInteger.valueOf(1);
        for (int j = 0; j < n; ++j) {
            for (int i = 1 + j; i <= m + j; ++i) {
                bns = bns.multiply(BigInteger.valueOf(i));
            }
        }
        System.out.println(ans.divide(bns).mod(BigInteger.valueOf(1000000009)).toString());
    }
}
