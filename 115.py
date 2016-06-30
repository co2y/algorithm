class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        # f(i,j) = f(i-1,j-1)+f(i-1,j)
        
        ls = len(s)
        lt = len(t)
        
        dp = [[0] * (lt+1) for _ in range((ls+1))]
        
        dp[0][0] = 1
        for i in range(ls):
            dp[i+1][0] = 1
        
        for i in range(ls):
            for j in range(lt):
                if s[i] == t[j]:
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1]
                else:
                    dp[i+1][j+1] = dp[i][j+1]
                
        
        return dp[ls][lt]