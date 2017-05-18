class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """

        def ok(a, b):
            c = a ^ b
            return (c & c - 1) == 0

        def dfs(step, prev):
            if find[0] == 1:
                return
            if step == total:
                find[0] = 1
                r[0] = ans[:]
            for i in range(1, total):
                if not used[i]:
                    if ok(i, prev):
                        used[i] = True
                        ans.append(i)
                        dfs(step + 1, i)
                        used[i] = False
                        ans.pop()

        total = 2**n
        used = [False] * total
        find = [0]
        ans = [0]
        r = [0]
        dfs(1, 0)
        return r[0]
