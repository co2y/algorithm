class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        # if n == 1:
        #     return 0
        # if n == 2:
        #     return 1
        # if n == 3:
        #     return 2
        
        
        # dp = [0] * (n+3)
        # dp[0] = 0
        # dp[1] = 1
        # dp[2] = 2
        
        # for i in range(3, n):
        #     if (i+1) % 2 == 0:
        #         dp[i] = dp[i//2] + 1
        #         dp[i+2] = dp[(i+2)//2] + 1
        #     else:
        #         dp[i] = min(dp[i-1], dp[i+1]) + 1 
                
                
        # return dp[n-1]
        
        if n == 1:
            return 0
        else:
            if n%2 ==0:
                return self.integerReplacement(n//2)+1
            else:
                return min(self.integerReplacement((n+1)//2),self.integerReplacement((n-1)//2))+2