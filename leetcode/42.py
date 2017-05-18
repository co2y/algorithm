# TLE
# class Solution(object):
#     def trap(self, height):
#         """
#         :type height: List[int]
#         :rtype: int
#         """
#         length = len(height)
#         if not length:
#             return 0
#         maxnumber = max(height)
#         ans = 0
#         for i in range(maxnumber):
#             left = 0
#             right = length - 1
#             hasleft = 0
#             hasright = 0
#             while left < right:
#                 if height[left] == 0 and hasleft == 0:
#                     left += 1
#                 else:
#                     hasleft = 1
#                 if height[right] == 0 and hasright == 0:
#                     right -= 1
#                 else:
#                     hasright = 1
#                 if hasleft and hasright and height[left] > 0:
#                     left += 1
#                 elif hasleft and hasright and height[left] == 0:
#                     ans += 1
#                     left += 1
#             for j in range(length):
#                 if height[j] > 0:
#                     height[j] = height[j] - 1
#         return ans

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height)
        if not length:
            return 0
        left = [0] * length
        right = [0] * length
        for i in range(1,length):
            left[i] = max(left[i-1], height[i-1])
        for i in range(length-2,-1,-1):
            right[i] = max(right[i+1], height[i+1])
        ans = 0
        for i in range(length):
            water = min(left[i],right[i])
            if water - height[i] > 0:
                ans = ans + water - height[i]
        return ans
