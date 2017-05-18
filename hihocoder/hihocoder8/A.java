package hihocoder;

import java.util.Scanner;

/**
 * Created by co2y on 05/03/2017.
 */
public class A {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T;
        T = scanner.nextInt();
        for (int i = 0; i < T; ++i) {
            long l, f, d;
            l = scanner.nextLong();
            f = scanner.nextLong();
            d = scanner.nextLong();
            if (f > l) {
                System.out.println("NO");
                continue;
            }

            if (f == l) {
                if (d % l == 0) System.out.println("YES");
                else System.out.println("NO");
                continue;
            }

            d = d % l;
            long temp = d;

            boolean flag = true;
            for (long j = 1; j <= l; ++j) {

                if (j != 1 && temp == j*d%l) break;

                if ((j * d) / l == (j * d + f) / l)
                    continue;


                System.out.println("NO");
                flag = false;
                break;

            }

            if (flag)
                System.out.println("YES");
        }
    }
}
