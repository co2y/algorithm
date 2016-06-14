class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
            
        s = dict()
        
        for i,each in enumerate(nums):
            if each in s and i-s[each]<=k:
                return True
            s[each] = i
        return False