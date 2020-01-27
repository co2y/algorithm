class Solution {
    private int max = 0;
    private int now = 0;
    private int[][] vis;
    private int[][] steps = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        vis = new int[n][m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    now = 0;
                    // vis[i][j] = 1;
                    dfs(grid, i, j);
                }
            }
        }
        
        return max;
    }
    
    
    private void dfs(int[][] grid, int i, int j) {
        
        vis[i][j] = 1;
        now++;
        // System.out.println(i + " " + j);
        if (now > max) max = now;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for (int[] step: steps) {
            int x = i + step[0];
            int y = j + step[1];
            
            if (x<0 || y<0 || x>=n || y >= m) continue;
            
            if (vis[x][y] == 0 && grid[x][y]==1) {
                
                dfs(grid, x, y);
            }
        }
    }
}