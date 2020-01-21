class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        
        int[][] vis = new int[row][column];
        
        Queue<int[]> q = new LinkedList<>();
        
        int freshCnt = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                    vis[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        
        if (freshCnt == 0) return 0;
        int ans = 0;
        
        int[][] steps = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            
            int size = q.size();
            
            for(int loopCnt = 0 ; loopCnt < size ; loopCnt++) {
                int[] index = q.poll();

                for (int[] step: steps) {
                    int n = index[0] + step[0];
                    int m = index[1] + step[1];
                    if ( n>=0 && n<row && m>=0 && m<column && vis[n][m]==0 && grid[n][m]==1 ) {
                        freshCnt--;
                        vis[n][m] = 1;
                        grid[n][m] = 2;
                        q.offer(new int[]{n,m});
                    } 
                }
            }
            
            ans++;
        }
        
        return freshCnt == 0? ans-1 : -1;
    }
}