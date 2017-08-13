package netease;

import java.util.Scanner;

/**
 * Created by co2y on 2017/8/12.
 */
public class AA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }


        for (int i = n - 1; i >= 0; i -= 2) {
            System.out.print(a[i]);
            System.out.print(" ");
        }

        for (int i = (n & 1); i < n; i += 2) {
            System.out.print(a[i]);
            if (i != n - 1 && i != n - 2)
                System.out.print(" ");
        }
    }
}
