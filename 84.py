class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        l = len(heights)
        left = [1] * l
        right = [1] * l
        
        # right
        for i in range(l-2,-1,-1):
            if heights[i] <= heights[i+1]:
                j = i+1
                while j<l and heights[j] >= heights[i]:
                    j = j+right[j]
                right[i] = j-i
                
        # left
        for i in range(1,l):
            if heights[i] <= heights[i-1]:
                j = i-1
                while j>=0 and heights[j] >= heights[i]:
                    j = j-left[j]
                left[i] = i-j
        
        # sum
        ans = 0
        for i in range(l):
            ans = max(ans, heights[i] * (left[i]+right[i]-1))
            
        return ans