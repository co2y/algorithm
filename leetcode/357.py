class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 1
        
        """
        dp[0] = 1
        dp[1] = 9
        dp[2] = 9*9
        dp[3] = 9*9*8
        dp[4] = 9*9*8*7
        """
        dp = [9, 9] + range(8, 0, -1)
        ans = 10
        
        tmp = 9
        for i in range(1, n):
            #ans += reduce(operator.mul, dp[:i+1])
            tmp = tmp * dp[i]
            ans += tmp
        
        return ans
        