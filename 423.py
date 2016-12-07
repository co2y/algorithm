from collections import Counter


class Solution(object):
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        d = Counter(s)
        ans = [0] * 10
        for x in '0eroz 2tow 4foru 6six 8eihtg 1eno 3theer 5ivef 7evens \
        9nnei'.split():
            ans[int(x[0])] = d[x[-1]]
            for c in x:
                d[c] -= d[x[-1]]
        return ''.join([str(i) * ans[i] for i in range(10)])

    def originalDigits2(self, s):
        d = Counter(s)
        res = []
        for x in '0eroz 6six 7evens 5fiev 8eihtg 4ourf 3treeh 2tow 1neo \
        9nnei'.split():
            res.append(x[0] * d[x[-1]])
            for c in x:
                d[c] -= d[x[-1]]
        return ''.join(sorted(res))
