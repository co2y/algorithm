package huawei;

import java.util.Scanner;

/**
 * Created by co2y on 24/03/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(new A().reverseAdd(a,b));

    }

    int reverseAdd(int a, int b) {
        if (a < 1 || a > 70000 || b < 1 || b > 70000) return -1;
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int aa = Integer.valueOf(sb.reverse().toString());
        sb = new StringBuilder();
        sb.append(b);
        int bb = Integer.valueOf(sb.reverse().toString());
        return aa + bb;
    }
}
