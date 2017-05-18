public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] ispal = new boolean[n][n];

        int[] d = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            d[i] = n - i - 1;
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i <= 1 || ispal[i + 1][j - 1])) {
                        ispal[i][j] = true;
                        if (j == n - 1)
                            d[i] = 0;
                        else
                            d[i] = Math.min(d[i], d[j + 1] + 1);
                    }
                }
            }
        }

        return d[0];
    }
}
