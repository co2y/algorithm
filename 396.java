public class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0;
        int F = 0;
        for (int i = 0; i < n; i++) {
            F += i * A[i];
            sum += A[i];
        }
        int max = F;
        for (int i = 1; i < n; i++) {
            F = F + sum - n * A[n-i];
            max = Math.max(F, max);
        }
        return max;

    }
}
