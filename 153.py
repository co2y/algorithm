class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        if n==1:
            return nums[0]
        s,l=0,n-1
        while l>s+2:
            m=(l+s)/2
            if nums[m]>nums[s] and nums[m]<nums[l]:
                return nums[s]
            if nums[m]<nums[s]:
                l=m
            elif nums[m]>nums[s]:
                s=m
        for i in range(s,l):
            if nums[i+1]<nums[i]:
                return nums[i+1]
        return nums[s]
        

// Lets represent rotated array 4567890123 as:
//             9
//           8    <--- top middle
//         7         
//       6
//     5
//   4
//  -0-1-2-3-4-5-6-7-8-9- [index] in array  
//                     3
//                   2
//                 1    <--- bottom middle
//               0
// When you do binary search your middle index is either on the "top" or "bottom" index
// when l == 0 and r == 9 then mid == 4, mid_number == nums[mid] == 8 
// I call it "top middle", since it always > than both nums[l] and nums[r] (4 < 8 > 3)
// so the min value is on the right side of it
// when l == 4 and r == 9 then mid == 7, mid_number == nums[mid] == 1 
// I call it "bottom middle" since it always < than both nums[l] and nums[r] (8 > 1 < 3)
// so the min value is somewhere on the left side of it
int findMin(vector<int>& nums) 
{
   int l = 0, r = nums.size() - 1;
   while(r - l > 1)
   {
       int mid = (l + r) / 2;
       if(nums[l] < nums[mid] && nums[mid] > nums[r])
       {
           l = mid; // top middle, min value is somewhere on the right
       }
       else
       {
           r = mid; // bottom middle, min value is somewhere on the left
       }
   }

   return min(nums[l], nums[r]);
}

# 学习C++解法的思路
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        
        while left < right - 1:
            mid = (left + right) // 2
            
            if nums[left] < nums[mid] and nums[mid] > nums[right]:
                left = mid
            else:
                right = mid
                
        return min(nums[left], nums[right])