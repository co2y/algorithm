class Solution {
    public int numWays(int steps, int arrLen) {
        
        int mod = (int)1e9 + 7;
        
        int distance = Math.min(steps, arrLen);
        int[][] dp = new int[steps+1][distance+1];
        
        dp[1][0]=1;
        dp[1][1]=1;
        for(int i = 2; i <= steps; i++) {
            for(int j = 0; j < distance; j++) {
                if (j == 0)
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % mod;
                else
                    dp[i][j] = ((dp[i-1][j] + dp[i-1][j+1]) % mod + dp[i-1][j-1]) % mod;
            }
        }
        
        return dp[steps][0];
    }
}