class Solution {
    private List<Integer> ans = new ArrayList<>();

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }

        for (int i = 1; i < 10; ++i) {
            dfs(1, N, i, K);
        }

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    void dfs(int step, int n, int num, int k) {
        if (step == n) {
            ans.add(num);
            return;
        }

        int d = num % 10;
        if (d - k >= 0) {
            dfs(step + 1, n, num * 10 + d - k, k);
        }

        if (d + k < 10 && k != 0) {
            dfs(step + 1, n, num * 10 + d + k, k);
        }

    }
}