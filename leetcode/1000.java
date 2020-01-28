
class Solution {
                                                 
    public int mergeStones(int[] stones, int sizeOfEach) {
        
        int len = stones.length;
        
        if ((len - 1) % (sizeOfEach - 1) != 0) {
            return -1;
        }
        
        int i, j, k, l, t;
        
        int[] prefixSum = new int[len + 1];
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        
        
        // trans1: dp[i][j][1] = dp[i][j][sizeOfEach] + sum[i][j] (dp[i][j][sizeOfEach] != max)
        // trans2: dp[i][j][k] = min(dp[i][t][k - 1] + dp[t + 1][j][1]) (t ∈ [i, j) && dp[i][t][k - 1] != max && dp[t+1][j][1] != max && k ∈ [2, sizeOfEach])

        // init: dp[i][i][1] = 0 (Already a pile) others = max
        // ans: dp[1][len][1] (len is the stones number)   
        int[][][] dp = new int[len + 1][len + 1][sizeOfEach + 1];
        int max = Integer.MAX_VALUE;
        for (i = 1; i <= len; i++) {
            for (j = 1; j <= len; j++) {
                for (k = 1; k <= sizeOfEach; k++) {
                    dp[i][j][k] = max;
                }
            }
        }
        
        for (i = 1; i <= len; i++) {
            dp[i][i][1] = 0;
        }

        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                for (k = 2; k <= sizeOfEach; k++) {
                    for (t = i; t < j; t++) {
                        if (dp[i][t][k - 1] == max || dp[t + 1][j][1] == max) {
                            continue;
                        }

                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }

                if (dp[i][j][sizeOfEach] == max) {
                    continue;
                }
                dp[i][j][1] = dp[i][j][sizeOfEach] + prefixSum[j] - prefixSum[i - 1];   
            }
        }

        return dp[1][len][1];
    }
    

    public int mergeStonesTwo(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int len = stones.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[len + 1][len + 1];
        int[] prefixSum = new int[len + 1];
        int i, j, k, l;
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        
        for (i = 1; i <= len; i++) {
            dp[i][i] = 0;
        }
        
        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                dp[i][j] = max;
                int sum = prefixSum[j] - prefixSum[i - 1];
                for (k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        
        return dp[1][len];
    }
}