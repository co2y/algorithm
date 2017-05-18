class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        
        l = len(dungeon)
        
        w = len(dungeon[0])
        
        dp = [[9223372036854775807] * (w+1) for i in range(l+1)]
        dp[l][w - 1] = 1
        
        for i in range(l-1,-1,-1):
            for j in range(w-1,-1,-1):
                dp[i][j] = max(min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1)
                
        return dp[0][0]
        
        