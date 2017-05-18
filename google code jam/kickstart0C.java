import java.util.Scanner;

/**
 * Created by co2y on 19/02/2017.
 */
public class kickstart0C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long num = Math.min(l, r);

            System.out.println("Case #" + i + ": " + (num * (num + 1) / 2));
        }
    }
}
