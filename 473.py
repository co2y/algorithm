class Solution(object):
    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return False

        total = sum(nums)
        if total % 4 != 0:
            return False

        target = total / 4
        l = len(nums)
        used = [False] * l
        find = [False]

        def dfs(step, now, index):
            if find[0]:
                return
            if step > 0 and not used[step]:
                return
            if step == 3:
                find[0] = True
                return

            for i in range(index, l):
                if used[i]:
                    continue
                if nums[i] + now < target:
                    used[i] = True
                    dfs(step, now + nums[i], i + 1)
                    used[i] = False
                elif nums[i] + now == target:
                    used[i] = True
                    dfs(step + 1, 0, 0)
                    used[i] = False

        nums.sort(reverse=True)
        dfs(0, 0, 0)
        return find[0]
