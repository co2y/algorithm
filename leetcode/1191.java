class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        boolean allNegative = allNeg(arr);
        if (allNegative) return 0;
        
        int max = getMax(arr);
        if (k==1) return max;
        
        
        int modulo = (int)1E9 + 7;
        int sum = getSum(arr);
        int priSum = prefixSum(arr);
        int subSum = subfixSum(arr);
        
        if (sum > 0) {
            int ans = 0;
            for (int i = 0; i < k-2; ++i) {
                ans = (ans + sum) % modulo;
            }
            return Math.max(max%modulo, (ans+priSum+subSum)%modulo);
        } else {
            return Math.max(max%modulo, (priSum+subSum)%modulo);
        }
        
    }
    
    private boolean allNeg(int[] arr) {
        for (int num : arr) {
            if (num > 0) return false;
        }
        
        return true;
    }
    
    private int getSum(int[] arr) {
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        return s;
    }
    
    private int getMax(int[] arr) {
        int m = 0;
        int now = 0;
        for (int num: arr) {
            now = now + num;
            if (now < 0) now = 0;
            m = Math.max(m, now);
        }
        return m;
    }
    
    private int prefixSum(int[] arr) {
        int m = 0;
        int now = 0;
        for (int num: arr) {
            now = now + num;
            m = Math.max(now, m);
        }
        return m;
    }
    
    private int subfixSum(int[] arr) {
        int m = 0;
        int now = 0;
        for (int i=arr.length-1; i>=0; i--) {
            int num = arr[i];
            now = now + num;
            m = Math.max(now, m);
        }
        return m;
    }
}