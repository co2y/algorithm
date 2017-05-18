class Solution(object):
    def canJump(self, nums):
        l = len(nums)
        if l <= 1:
            return True
        ans = True
        temp = 0
        for i in range(l-2, -1, -1):
            if not nums[i] and ans:
                temp = i
                ans = False
            elif temp and temp - i < nums[i] and not ans:
                ans = True
        if ans and nums[0]:
            return True
        else:
            return False
