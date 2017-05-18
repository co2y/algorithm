class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0

        l = len(triangle)
        
        dp = triangle[-1][:]

        for i in range(l-2,-1,-1):
            temp = []

            for j in range(len(triangle[i])):
                temp.append(min(dp[j]+triangle[i][j],dp[j+1]+triangle[i][j]))

            dp = temp[:]
        return dp[0]
