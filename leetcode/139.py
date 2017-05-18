class Solution(object):
    def wordBreak(self, s, wordDict):
        dp = [False] * (len(s) + 1)
        if s is None:
            return True
        dp[0] = True

        for i in range(len(s)):
            for j in range(i,-1,-1):
                if dp[j] and s[j:i+1] in wordDict:
                    dp[i+1] = True

        return dp[len(s)]
