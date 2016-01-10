class Solution(object):

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        temp = ""

        def dfs(l_list, pos, n, used):
            global temp
            if pos == n * 2:
                l_list.append(temp)
                return
            if used < n:
                temp += "("
                dfs(l_list, pos + 1, n, used + 1)
                temp = temp[:-1]
            if used * 2 > pos:
                temp += ")"
                dfs(l_list, pos + 1, n, used)
                temp = temp[:-1]

        l = []
        if n == 0:
            return l
        dfs(l, 0, n, 0)
        return l
