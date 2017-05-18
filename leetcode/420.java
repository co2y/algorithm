import java.util.Scanner;

/**
 * Created by co2y on 07/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwd = scanner.next();
        System.out.println(check(passwd));
    }

    public static int check(String s) {
        if (s.length() < 2) return 6 - s.length();

        char now = s.charAt(0);
        boolean hasUpper = false;
        if (now >= 'A' && now <= 'Z') hasUpper = true;
        boolean hasLower = false;
        if (now >= 'a' && now <= 'z') hasLower = true;
        boolean hasDigit = false;
        if (now >= '0' && now <= '9') hasDigit = true;

        int rep = 1;
        int ans = 0;
        int[] delete = new int[3];

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == now) {
                rep++;
            } else {
                ans += rep / 3;
                if (rep / 3 > 0) {
                    ++delete[rep % 3];
                }
                now = s.charAt(i);
                hasUpper = hasUpper || now >= 'A' && now <= 'Z';
                hasLower = hasLower || now >= 'a' && now <= 'z';
                hasDigit = hasDigit || now >= '0' && now <= '9';
                rep = 1;
            }
        }
        ans += rep / 3;
        if (rep / 3 > 0) ++delete[rep % 3];

        int miss = (hasUpper ? 0 : 1) + (hasLower ? 0 : 1) + (hasDigit ? 0 : 1);

        if (s.length() > 20) {
            int del = s.length() - 20;

            if (del <= delete[0]) {
                ans -= del;
            } else if (del - delete[0] <= 2 * delete[1]) {
                ans -= delete[0] + (del - delete[0]) / 2;
            } else {
                ans -= delete[0] + delete[1] + (del - delete[0] - 2 * delete[1]) / 3;
            }
            return del + Math.max(miss, ans);
        } else {
            return Math.max(6 - s.length(), Math.max(miss, ans));
        }
    }
}
