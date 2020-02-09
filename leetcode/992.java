class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostK(A, K) - mostK(A, K-1);
    }
    
    private int mostK(int[] A, int K) {
        int l=0,r=0,ans=0,cnt=0;
        HashMap<Integer, Integer> count = new HashMap<>();
        
        while (r<A.length) {
            if (count.getOrDefault(A[r], 0) == 0) {
                cnt++;
            }
            count.put(A[r], count.getOrDefault(A[r], 0) + 1);
            
            while (l<=r && cnt > K) {
                count.put(A[l], count.get(A[l])-1);
                if (count.get(A[l]) == 0) {
                    cnt--;
                }
                l++;
            }
            r++;
            ans += r - l;
            
        }
        
        return ans;
    } 
}