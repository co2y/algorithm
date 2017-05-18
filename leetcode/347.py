class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return 0
        s = dict()
        for each in nums:
            if each not in s:
                s[each] = 1
            else:
                s[each] += 1
                
        s = sorted(s.iteritems(),key = lambda d:d[1], reverse = True)
        ans = list()
        for i in range(k):
            ans.append(s[i][0])
        return ans
        