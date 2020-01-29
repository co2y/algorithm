class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(f(A,L,M), f(A,M,L));
    }
    
    private int f(int[] nums, int a, int b) {
        int n = nums.length;
        
        int prefixSum = 0;
        int[] prefixMax = new int[n];
        for (int i = 0; i < n; ++i) {

            prefixSum += nums[i];

            if (i < a - 1) {
                prefixMax[i] = 0;
                continue;
            }

            prefixMax[i] = (i>0) ? Math.max(prefixMax[i-1], prefixSum) : prefixSum;

            prefixSum -= nums[i - a + 1];

        }

        int subfixSum = 0;
        int[] subfixMax = new int[n];

        for (int i = n-1; i >= 0; --i) {

            subfixSum += nums[i];

            if (i > (n-b)) {
                subfixMax[i] = 0;
                continue;
            }

            subfixMax[i] = (i<n-1) ? Math.max(subfixMax[i+1], subfixSum) : subfixSum;

            subfixSum -= nums[i + b - 1];
        }

        int ans = 0;

        for (int i = a-1 ; i < n-b; ++i) {
            ans = Math.max(ans, prefixMax[i]+subfixMax[i+1]);
        }

		return ans;
	}
}