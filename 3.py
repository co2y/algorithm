class Solution(object):

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        search_list = {}
        index = -1
        res = 0
        for i, each_char in enumerate(s):
            if each_char not in search_list:
                search_list[each_char] = -1
            index = max(index, search_list[each_char])
            res = max(res, i - index)
            search_list[each_char] = i
        return res
# hash表很重要
