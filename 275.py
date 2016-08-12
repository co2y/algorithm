class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if not citations:
            return 0
            
        length = len(citations)
        left = 0
        right = length
        find = 0
        while left <= right:
            mid = left + (right-left)//2
            if citations[length-mid if mid>0 else 0] >= mid:
                find = mid
                left = mid + 1
            else:
                right = mid - 1
                
        return find
# [1,3,7,8,9] length=5 find=3