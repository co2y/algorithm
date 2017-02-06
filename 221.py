class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])

        ans = 0
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(m):
            if matrix[i][0] == '1':
                dp[i][0] = 1
                ans = 1

        for j in range(n):
            if matrix[0][j] == '1':
                dp[0][j] = 1
                ans = 1

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1],
                                   dp[i - 1][j - 1]) + 1
                    ans = max(ans, dp[i][j])

        return ans * ans
