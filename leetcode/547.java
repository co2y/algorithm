class Solution {
    private int count;
    int[] rank;
    int[] father;
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        father = new int[n];
        rank = new int[n];
        count = n;
        
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
        
        for (int i = 0; i < M.length; ++i) {
            for (int j = i + 1; j < M[i].length; ++j) {
                if (M[i][j] == 1) {
                    union(i, j, father);
                }
            }
        }
        
        return count;
        
    }
    
    private void union(int i, int j, int[] father) {
        int ir = find(i, father);
        int jr = find(j, father);
        if (ir == jr) {
            return;
        }
        
        if (rank[ir] > rank[jr]) {
            father[jr] = ir;
        } else {
            father[ir] = jr;
            if (rank[ir] == rank[jr]) {
                rank[ir]++;
            }
        }
        count--;
    }
    
    private int find(int x, int[] father) {
        if (father[x] != x) {
            father[x] = find(father[x], father);
        }
        return father[x];
    }
}