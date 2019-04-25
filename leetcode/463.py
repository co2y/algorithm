class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        def dfs(i, j):
            if vis[i][j]:
                return
            c = 4
            vis[i][j] = True
            if i+1 < m and grid[i+1][j] == 1:
                dfs(i+1, j)
                c = c - 1
            if i-1 >= 0 and grid[i-1][j] == 1:
                dfs(i-1, j)
                c = c - 1
            if j + 1 < n and grid[i][j+1] == 1:
                dfs(i, j+1)
                c = c - 1
            if j - 1 >= 0 and grid[i][j-1] == 1:
                dfs(i, j-1)
                c = c - 1
            ans[0] = ans[0] + c
            
        ans = [0]
        m = len(grid)
        n = len(grid[0])
            
        vis = [[False for _ in range(n)] for _ in range(m)]
        for x in range(m):
            for y in range(n):
                if grid[x][y] == 1:
                    dfs(x, y)
                    return ans[0]            
        
        return 0
        
        