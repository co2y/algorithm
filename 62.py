class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        
        dp = [[0]*n for i in range(m)]
        dp[0][0] = 1 
        
        for i in range(1,m):
            dp[i][0] = dp[i-1][0]
                
        for j in range(1,n):
            dp[0][j] = dp[0][j-1]
                
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m-1][n-1]