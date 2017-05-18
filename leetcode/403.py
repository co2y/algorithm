# use set not dict
class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        dic = set()
        mem = set()
        for stone in stones:
            dic.add(stone)

        find = [False]

        def dfs(stone, speed):
            if stone == stones[-1]:
                find[0] = True

            if find[0]:
                return

            if stone not in dic:
                return

            if (stone, speed) in mem:
                return

            mem.add((stone, speed))

            for s in range(speed - 1, speed + 2):
                dfs(stone + s, s)

        dfs(1, 1)
        return find[0]
