class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        length = len(ratings)
        rlist = [1] * length
        for i in range(length-1):
            if ratings[i+1] > ratings[i]:
                rlist[i+1] = rlist[i]+1
        for i in range(length-1,0,-1):
            if ratings[i] < ratings[i-1]:
                rlist[i-1] = max(rlist[i-1],rlist[i]+1)
        return sum(rlist)