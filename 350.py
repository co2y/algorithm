class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        from collections import Counter
        c1 = Counter(nums1)
        c2 = Counter(nums2)

        if len(c1) > len(c2):
        	c1,c2 = c2,c1

        ans = []
        
        for each in c1:
        	if each in c2:
        		ans+= [each]*min(c1[each],c2[each])

        return ans