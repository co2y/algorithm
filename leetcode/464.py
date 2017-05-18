class Solution(object):
    def canIWin(self, maxChoosableInteger, desiredTotal):
        """
        :type maxChoosableInteger: int
        :type desiredTotal: int
        :rtype: bool
        """
        if (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal:
            return False

        self.memo = {}
        return self.dfs(range(1, maxChoosableInteger + 1), desiredTotal)

    def dfs(self, nums, desiredTotal):
        s = str(nums)
        if s in self.memo:
            return self.memo[s]

        if nums[-1] >= desiredTotal:
            return True

        for i in range(len(nums)):
            if not self.dfs(nums[:i] + nums[i + 1:], desiredTotal - nums[i]):
                self.memo[s] = True
                return True
        self.memo[s] = False
        return False
