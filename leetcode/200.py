class Solution(object):
    def numIslands(self, grid):
        if not grid:
            return 0

        row = len(grid)
        col = len(grid[0])
        ans = 0
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    ans += 1

        return ans

    def dfs(self, grid, i, j):
        grid[i][j] = '0'

        row = len(grid)
        col = len(grid[0])

        if i - 1 >= 0 and grid[i-1][j]=='1':
            self.dfs(grid, i-1, j)

        if i + 1 < row and grid[i+1][j]=='1':
            self.dfs(grid, i+1, j)

        if j - 1 >= 0 and grid[i][j-1]=='1':
            self.dfs(grid, i, j-1)

        if j + 1 < col  and grid[i][j+1]=='1':
            self.dfs(grid, i, j+1)
