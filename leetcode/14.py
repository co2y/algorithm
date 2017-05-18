class Solution(object):

    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        i = 0
        find = 1
        try:
            while find:
                temp = strs[0][i]
                for each_str in strs:
                    if each_str[i] != temp:
                        find = 0
                i += 1
            return strs[0][:i - 1]
        except:
            if i != 0:
                return strs[0][:i]
            return ''
