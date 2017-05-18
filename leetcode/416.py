# TLE
class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sums = sum(nums)
        if sums % 2 == 1:
            return False
        target = sums / 2

        s1 = [0]
        s2 = [0]

        n = len(nums)

        flag = [False]

        def dfs(step):
            if step == n:
                if s1[0] == target and s2[0] == target:
                    flag[0] = True
                return

            if flag[0]:
                return

            for i in range(step, n):
                if s1[0] + nums[i] <= target:
                    s1[0] = s1[0] + nums[i]
                    dfs(step + 1)
                    s1[0] = s1[0] - nums[i]
                if s2[0] + nums[i] <= target:
                    s2[0] = s2[0] + nums[i]
                    dfs(step + 1)
                    s2[0] = s2[0] - nums[i]

        dfs(0)
        return flag[0]


class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        possible_sums = {0}
        for n in nums:
            possible_sums.update({(v + n) for v in possible_sums})
        return (sum(nums) / 2.) in possible_sums


class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return True

        sums = sum(nums)
        if sums % 2 == 1:
            return False
        target = sums / 2
        n = len(nums)

        dp = [[False for _ in range(target + 1)] for _ in range(n + 1)]

        for i in range(n):
            dp[i][0] = True

        for j in range(target):
            dp[0][j] = False

        dp[0][0] = True

        for i in range(1, n + 1):
            for j in range(1, target + 1):
                dp[i][j] = dp[i - 1][j]
                if j >= nums[i - 1]:
                    dp[i][j] = (dp[i][j] or dp[i - 1][j - nums[i - 1]])

        return dp[n][target]
