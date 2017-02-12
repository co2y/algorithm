class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        r = sorted(enumerate(nums), key=lambda x: x[1], reverse=True)
        ans = [0] * len(nums)

        for i in range(len(nums)):
            if i == 0:
                ans[r[0][0]] = "Gold Medal"
            elif i == 1:
                ans[r[1][0]] = "Silver Medal"
            elif i == 2:
                ans[r[2][0]] = "Bronze Medal"
            else:
                ans[r[i][0]] = str(i + 1)
        return ans
