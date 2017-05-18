class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        p2 = 0
        p3 = 0
        p5 = 0
        unums = [0] * n
        unums[0] = 1
        for i in range(1, n):
            u2 = 2*unums[p2]
            u3 = 3*unums[p3]
            u5 = 5*unums[p5]
            unums[i] = min(u2,u3,u5)
            if unums[i] == u2:
                p2 += 1
            if unums[i] == u3:
                p3 += 1
            if unums[i] == u5:
                p5 += 1

        return unums[n-1]