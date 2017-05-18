package wanmei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by co2y on 29/03/2017.
 */
public class A {
    private static boolean find;
    private static double[] nums;
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        find = false;
        nums = new double[4];
        used = new boolean[4];
        for (int i = 0; i < 4; ++i) {
            nums[i] = scanner.nextDouble();
        }
        used[0] = true;
        dfs(1, nums[0]);
        if (find) {
            System.out.println("yes");
            return;
        }
        Arrays.fill(used, false);
        used[1] = true;
        dfs(1, nums[1]);
        if (find) {
            System.out.println("yes");
            return;
        }
        Arrays.fill(used, false);
        used[2] = true;
        dfs(1, nums[2]);
        if (find) {
            System.out.println("yes");
            return;
        }
        Arrays.fill(used, false);
        used[3] = true;
        dfs(1, nums[3]);
        if (find) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");

    }

    private static void dfs(int step, double ans) {
        if (step == 4) {
            if (Math.abs(ans - 24) < 1e-9)
                find = true;
            return;
        }
        if (find) return;
        for (int i = 0; i < 4; ++i) {
            if (!used[i]) {
                used[i] = true;
                dfs(step + 1, ans + nums[i]);
                dfs(step + 1, ans - nums[i]);
                dfs(step + 1, ans * nums[i]);
                dfs(step + 1, ans / nums[i]);
                used[i] = false;
            }
        }
    }
}
