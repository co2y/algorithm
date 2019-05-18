class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i > 0)
                sum[i] = nums[i] + sum[i-1];
            else
                sum[i] = nums[i];
        }
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        
        for (int i = n-1; i >= 0; --i) {
            for (int j = i+1; j < n; ++j) {
                int s = sum[j]-sum[i]+nums[i];
                dp[i][j] = Math.max(s-dp[i+1][j], s-dp[i][j-1]);
            }
        }
        
        return dp[0][n-1]>=sum[n-1]-dp[0][n-1];
        
    }
}