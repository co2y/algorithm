package wanmei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by co2y on 29/03/2017.
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int d = scanner.nextInt();
            BigInteger bigInteger = BigInteger.ONE;
            for (int i = 1; i < d; ++i) {
                bigInteger = (bigInteger.add(BigInteger.valueOf(3))).multiply(BigInteger.valueOf(2));
            }
            System.out.println(bigInteger.toString());
        }

    }
}
