class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] count = new int[n];
        count[0] = 1;

        for (int i = 1; i < n; ++i) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = i-1 ; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxCount = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > maxCount) maxCount = dp[i];
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == maxCount) ans += count[i];
        }
        
        return ans;
    }
}