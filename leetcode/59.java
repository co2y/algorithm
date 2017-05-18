public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int i = 0;
        int j = -1;
        int num = 1;
        while(true) {

            while (j<n-i-1) {
                j++;
                mat[i][j] = num;
                num++;

            }
            if (num > n*n) break;


            while (i<j) {
                i++;
                mat[i][j] = num;
                num++;

            }


            while (j>n-i-1) {
                j--;
                mat[i][j] = num;
                num++;

            }
            if (num > n*n) break;


            while (i>j+1) {
                i--;
                mat[i][j] = num;
                num++;

            }

        }
        return mat;
    }
}
