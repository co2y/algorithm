class Solution(object):

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """

        x_map = {'0': [' '], '1': ['*'], '2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'], '5': ['j', 'k', 'l'], '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'], '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']}
        r_list = []
        word = []
        if not digits:
            return []

        def dfs(cur):
            if cur == len(digits):
                r_list.append(''.join(word))
            else:
                for each_char in x_map[(digits[cur])]:
                    word.append(each_char)
                    dfs(cur + 1)
                    word.pop()
        dfs(0)
        return r_list
