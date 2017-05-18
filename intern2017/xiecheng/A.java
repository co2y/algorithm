package xiecheng;

import java.util.Scanner;

/**
 * Created by co2y on 11/04/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int[] chs = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chs[c - 'a']++;
            count++;
        }
        double ans = 0;
        for (int i = 0; i < 26; i++) {
            double p = (double) chs[i] / count;
            if (p > 0)
                ans += -(p * Math.log(p) / Math.log(2));
        }
        if (String.valueOf(ans).split("\\.")[1].length() <= 7)
            System.out.println(ans);
        else
            System.out.println(String.format("%.7f", ans));
    }
}
