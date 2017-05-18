import java.util.Scanner;

/**
 * Created by co2y on 19/02/2017.
 */
public class kickstart0B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            double ans = (double) (N - M) / (N + M);
            System.out.println("Case #" + i + ": " + String.format("%.8f", ans));
        }
    }
}
