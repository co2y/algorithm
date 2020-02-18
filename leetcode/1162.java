class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        
        int ans = -1;
        
        int[][] steps = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()) {
            int[] e = q.poll();
            for (int[] step : steps) {
                int x = step[0] + e[0];
                int y = step[1] + e[1];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y]==0) {
                    grid[x][y] = 1;
                    ans = Math.max(ans, e[2]+1);
                    q.offer(new int[]{x, y, e[2]+1});
                }
            }
        }
        
        return ans;
    }
}