class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = [0]

        cols = [False] * n
        d1 = [False] * 2 * n
        d2 = [False] * 2 * n

        def dfs(step, cols, d1, d2):
            if step == n:
                ans[0] += 1

            for col in range(n):
                id1 = col - step + n
                id2 = col + step

                if cols[col] or d1[id1] or d2[id2]:
                    continue

                cols[col] = True
                d1[id1] = True
                d2[id2] = True
                dfs(step + 1, cols, d1, d2)
                cols[col] = False
                d1[id1] = False
                d2[id2] = False

        dfs(0, cols, d1, d2)

        return ans[0]
