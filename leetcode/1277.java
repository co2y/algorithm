class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        int[][] sum = new int[m][n];
        
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; ++i) {
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        
        for (int j = 1; j < n; ++j) {
            sum[0][j] = sum[0][j-1] + matrix[0][j];
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 1; ; k++) {
                    if (i+k > m || j+k > n) break;
                    
                    if (k==1) {
                        if (matrix[i][j]==1) ans++;
                        continue;
                    } 
                    
                    
                    int topRight = 0;
                    int topLeft = 0;
                    int bottomLeft = 0;
                    if (i-1>=0) topRight = sum[i-1][j+k-1];
                    if (j-1>=0) bottomLeft = sum[i+k-1][j-1];
                    if (i-1>=0&&j-1>=0) topLeft = sum[i-1][j-1];
                    
                    if ((sum[i+k-1][j+k-1] - topRight - bottomLeft + topLeft) == k*k) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}