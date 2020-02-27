class Solution {
    public int numEnclaves(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if (A[i][j] == 1) {
                        dfs(i, j, A, n, m);
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (A[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void dfs(int i, int j, int[][] A, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m) {
            return;
        }
        
        if (A[i][j] == 0) {
            return;
        }
        
        A[i][j] = 0;
        dfs(i-1, j, A, n, m);
        dfs(i+1, j, A, n, m);
        dfs(i, j-1, A, n, m);
        dfs(i, j+1, A, n, m);
    }
}