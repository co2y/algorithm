class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> bfs = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    bfs.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!bfs.isEmpty()) {
            int[] now = bfs.poll();
            for (int[] dir : dirs) {
                int x = now[0] + dir[0];
                int y = now[1] + dir[1];
                
                if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) {
                    continue;
                }
                vis[x][y] = true;
                matrix[x][y] = matrix[now[0]][now[1]] + 1;
                bfs.offer(new int[]{x, y});
            }
        }

        return matrix;
    }
}