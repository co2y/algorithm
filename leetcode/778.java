class Solution {
    private static class UnionFind {
        int[] father;
        int[] rank;
        
        UnionFind(int n) {
            father = new int[n*n];
            rank = new int[n*n];
            for (int i = 0; i < n*n; ++i) {
                father[i] = i;
            }
        }
        
        boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
        
        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
        
        void union(int i, int j) {
            int fi = find(i);
            int fj = find(j);
            if (fi == fj) {
                return;
            }
            
            if (rank[fi] < rank[fj]) {
                father[fi] = fj;
            } else {
                father[fj] = fi;
                if (rank[fi] == rank[fj]) {
                    rank[fi]++;
                }
            }
        }
        
    }
    
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int time = 0;
        UnionFind uf = new UnionFind(n);
        while(!uf.isConnected(grid[0][0], grid[n-1][n-1])) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] > time) {
                        continue;
                    }
                    if (i+1 < n && grid[i+1][j] <= time) {
                        uf.union(grid[i+1][j], grid[i][j]);
                    }
                    if (j+1 < n && grid[i][j+1] <= time) {
                        uf.union(grid[i][j+1], grid[i][j]);
                    }
                }
            }
            time++;
        }
        
        return time-1;
    }
}