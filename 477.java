class Solution {
    //     public int totalHammingDistance(int[] nums) {
    //         int n = nums.length;
    //         int ans = 0;
    //         for (int i = 0; i < n; ++i) {
    //             for (int j = i+1; j < n; ++j) {
    //                 int tmp = nums[i] ^ nums[j];
    //                 ans += getNumOfOne(tmp);
    //             }
    //         }
    //         return ans;
    //     }
        
    //     private int getNumOfOne(int num) {
    //         int count = 0;
    //         while (num != 0) {
    //             num = num & (num - 1);
    //             count++;
    //         }
    //         return count;
    //     }
        
        public int totalHammingDistance(int[] nums) {
            int n = nums.length;
            int ans = 0;
            
            for (int i=0; i<32; ++i) {
                
                int bitCount = 0;
                
                for (int j=0 ; j<n; ++j) {
                    bitCount += (nums[j] >> i) & 1;    
                }
                
                ans += bitCount * (n - bitCount);
                
            }
            
            return ans;
        }
        
    }