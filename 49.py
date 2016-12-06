# 映射成一个大质数，或者其它的， 用空间换时间

# 排序做法
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """



        h = collections.defaultdict(list)
        for s in strs:
            h[''.join(sorted(s))].append(s)
        return map(sorted, h.values())


# 保证内部字典序
class Solution(object):
    def groupAnagrams(self, strs):
        sorted_list = [sorted(s) for s in strs]

        d = collections.defaultdict(list)

        for index, sorted_word in enumerate(sorted_list):
            d["".join(sorted_word)].append(index)

        ans = []
        for each in d.values():
            ans.append(sorted([strs[index] for index in each]))

        return ans
