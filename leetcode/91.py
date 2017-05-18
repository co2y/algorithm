class Solution(object):
    def numDecodings(self, s):
        if not s or s[0]=='0':
            return 0
        dp = [0] * (len(s)+1)
        dp[0] = 1
        for i in range(1, len(s)+1):
            if s[i-1] != '0':
                dp[i] += dp[i-1]
            if '10' <= s[i-2:i] <= '26' and i > 1:
                dp[i] += dp[i-2]
        return dp[-1]

