package hihocoder10;

import java.util.Scanner;

/**
 * Created by co2y on 19/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; ++i) {
            String s = scanner.next();
            int absent = 0;
            int late = 0;
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == 'A') {
                    absent++;
                    late = 0;
                }
                if (absent > 1) {
                    System.out.println("NO");
                    break;
                }
                if (s.charAt(j) == 'L')
                    late++;
                if (late == 3) {
                    System.out.println("NO");
                    break;
                }
                if (s.charAt(j) == 'O')
                    late = 0;
                if (j == s.length() - 1)
                    System.out.println("YES");
            }
        }
    }
}
