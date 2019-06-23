#### Shortest Common Supersequence

```
class Solution {
    private int[][] dp;
    
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int l = lcs(str1, str2);
            
        StringBuilder sb = new StringBuilder();
        
        int i = str1.length();
        int j = str2.length();
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] < dp[i][j-1]) {
                sb.append(str2.charAt(j-1));
                j--;
            } else {
                sb.append(str1.charAt(i-1));
                i--;
            }
            
        }
        
        while (i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        
        while (j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        return sb.reverse().toString();
    }
    
    private int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        dp = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}
```