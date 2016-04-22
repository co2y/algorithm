class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums_set = set(nums)
        
        ans = 0
        
        while nums_set:
            one = nums_set.pop()
            
            length = 1
            
            smaller = one - 1
            bigger = one + 1
            
            while smaller in nums_set:
                nums_set.discard(smaller)
                length += 1
                smaller -= 1 
                
            while bigger in nums_set:
                nums_set.discard(bigger)
                length += 1
                bigger += 1
                
            ans = max(ans,length)
            
        return ans