# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        d = dict()
        l = len(intervals)
        for i in range(l):
            d[intervals[i]] = i

        order = sorted(intervals, key=lambda x:x.start)
        ans = []

        def bs(x):
            left = 0
            right = len(order)-1
            while left<right:
                mid = (left+right) // 2
                if x == order[mid].start:
                    return d[order[mid]]
                elif x<order[mid].start:
                    right = mid
                else:
                    left = mid+1

            return d[order[right]] if order[right].start>=x else -1


        for each in intervals:
            s = each.end
            r = bs(s)
            ans.append(r)

        return ans
            
