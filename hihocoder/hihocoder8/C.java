package hihocoder;

import java.util.Scanner;

/**
 * Created by co2y on 05/03/2017.
 */
public class C {
    private static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        int[] nums = new int[N];
        int[] sums = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            nums[i] = scanner.nextInt();
            sums[i + 1] = nums[i] + sums[i];
        }

        dfs(sums, nums, 0, N);
        System.out.println(ans % 1000000007);


    }

    private static void dfs(int[] sums, int[] nums, int i, int n) {
        if (i == n) ans++;
        else {
            for (int k = i; k < n; ++k) {
                if (sums[k + 1] - sums[i] != 0) dfs(sums, nums, k + 1, n);
            }
        }

    }


}
