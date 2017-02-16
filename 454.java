public class leet454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> CD = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                CD.put(C[i] + D[j], CD.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int ans = 0;
        for (int aA : A)
            for (int j = 0; j < n; ++j)
                ans += CD.getOrDefault(-1 * (aA + B[j]), 0);
        return ans;
    }

}
