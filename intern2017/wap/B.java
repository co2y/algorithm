/**
 * Created by co2y on 28/09/2017.
 */

import java.util.Scanner;
import java.util.Stack;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, x, ans = 0;
        n = in.nextInt();
        int[] num = new int[n];
        for (int i = 1; i <= n; i++) {
            x = in.nextInt();
            num[i - 1] = x;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s = new Stack<>();

        s.push(num[0]);

        for (int i = 1; i < n; ++i) {
            getMax(num, i, s, left);
        }


        s = new Stack<>();
        s.push(num[num.length - 1]);

        for (int i = n - 2; i >= 0; --i) {
            getMax(num, i, s, right);
        }

        for (int i = 0; i < n; ++i) {

            if (left[i] != 0)
                ans = Math.max(ans, num[i] ^ left[i]);
            if (right[i] != 0)
                ans = Math.max(ans, num[i] ^ right[i]);
        }

        System.out.println(ans);
    }

    private static void getMax(int[] num, int i, Stack<Integer> s, int[] side) {
        if (num[i] < s.peek()) {
            side[i] = s.peek();
            s.push(num[i]);
        } else if (num[i] > s.peek()) {
            s.pop();
            while (!s.empty()) {

                if (num[i] < s.peek()) {
                    side[i] = s.peek();
                    break;
                }
                s.pop();
            }
            s.push(num[i]);
        }
    }
}
