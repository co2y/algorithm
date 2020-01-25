class Solution {
    int nowSize = 0;
    int maxSize = 0;
    int[][] vis;
    
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 1;
        vis = new int[m][n];
        
        boolean change = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    change=true;
                    vis = new int[m][n];
                    grid[i][j] = 1;
                    
                    vis[i][j] = 1;
                    nowSize = 0;
                    maxSize = 0;
                    dfs(i,j,grid);
                    if (maxSize > ans) ans = maxSize;
                    
                    grid[i][j] = 0;
                }
            }
        }
        
        if (!change) {
            vis[0][0] = 1;
            dfs(0,0,grid);
            if (maxSize > ans) ans = maxSize;
        }
        
        
        return ans;
        
    }
    
    
    void dfs(int x, int y, int[][] grid) {
        
        if (grid[x][y] == 0) return;
        nowSize++;
        if (nowSize > maxSize) maxSize = nowSize;
        
        int[][] steps = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int[] step: steps) {
            int tmpX = x + step[0];
            int tmpY = y + step[1];
            
            if (tmpX < 0 || tmpY < 0 || tmpX == m || tmpY == n ) {
                continue;
            }
            
            if (vis[tmpX][tmpY] == 0) {
                vis[tmpX][tmpY] = 1;
                dfs(tmpX, tmpY, grid);
            }
        }
    }
}