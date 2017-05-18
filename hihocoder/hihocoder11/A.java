package hihocoder11;

import java.util.Scanner;

/**
 * Created by co2y on 26/03/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        char[] chars = line.toCharArray();
        int l = chars.length;
        int ans = l + 1;
        for (int i = 0; i < l - 3; i++) {
            int counti = 0;
            int counto = 0;
            int counth = 0;
            for (int j = i; j < l; j++) {
                if (chars[j] == 'h') counth++;
                else if (chars[j] == 'o') counto++;
                else if (chars[j] == 'i') counti++;
                if (counth == 2 && counti == 1 && counto == 1) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
                if (counth > 2 || counti > 1 || counto > 1) break;
            }
        }

        if (ans == l + 1) System.out.println(-1);
        else System.out.println(ans);
    }
}
