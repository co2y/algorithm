public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int k = 30;
        int n0 = 0;
        int n1 = 0;
        for (int i=0; i<=30; ++i){
            for (int num: nums) {
                int temp = num >> i;
                if ((temp & 1) == 1) {
                    n1 ++;
                }
                else{
                    n0 ++;
                }
            }
            ans = ans + n1 * n0;
            n1 = 0;
            n0 = 0;
        }
        return ans;
    }
}
