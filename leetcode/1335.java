class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) return -1;

        int[][] dp = new int[n][d];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(jobDifficulty[i], dp[i-1][0]);
        }

        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {

                dp[j][i] = Integer.MAX_VALUE;
                int rightMax = jobDifficulty[j];

                for (int k = j-1; k >= (i-1); --k) {
                    dp[j][i] = Math.min(dp[j][i], dp[k][i-1] + rightMax);
                    rightMax = Math.max(rightMax, jobDifficulty[k]);
                }

            }
        }


        return dp[n-1][d-1];
    }
}