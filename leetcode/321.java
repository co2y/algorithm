class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int n = nums1.length;
        int m = nums2.length;
        
        int start = Math.max(0, k-m);
        for (int i = start; i <= Math.min(n, k); ++i) {
            int[] ret1 = maxNumber(nums1, i);
            int[] ret2 = maxNumber(nums2, k-i);
            
            int[] ret = merge(ret1, ret2);
            
            if (large(ret, 0, ans, 0)) ans = ret;
        }
        
        return ans;
    }
    
    private int[] merge(int[] num1, int[] num2) {
        int n = num1.length;
        int m = num2.length;
        int k = n + m;
        int[] ret = new int[k];
        
        int i = 0;
        int j = 0;
        int now = 0;
        while (i < n && j < m) {
            if (large(num1, i, num2, j)) {
                ret[now++] = num1[i++];
            } else {
                ret[now++] = num2[j++];
            }
        }
        
        while (i < n) {
            ret[now++] = num1[i++];
        }
        
        while (j < m) {
            ret[now++] = num2[j++];
        }
        
        return ret;
    }
    
    public boolean large(int[] num1, int start1, int[] num2, int start2) {
        for (; start1 < num1.length && start2 < num2.length; start1++, start2++) {
            if (num1[start1] > num2[start2]) return true;
            if (num1[start1] < num2[start2]) return false;
        }
        return start1 != num1.length;
    }
    
    private int[] maxNumber(int[] num, int k) {
        int[] ret = new int[k];
        
        int n = num.length;
        int now = 0;
        for (int i = 0; i < n; ++i) {
            while (now > 0 && now + n - i > k && ret[now-1] < num[i]) {
                now--;
            }
            
            if (now < k) {
                ret[now] = num[i];
                now++;
            }
        }
        
        return ret;
    }
}