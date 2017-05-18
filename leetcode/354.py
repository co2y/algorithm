class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        def f(x,y):
            return -1 if (x[0] < y[0] or x[0] == y[0] and x[1] > y[1]) else 1
        envelopes.sort(cmp=f)
        
        
        def getidx(e, d, l):
            if l == 0:
                return 0
            if e[1] > d[-1]:
                return l
            begin = 0
            end = l
            while begin < end:
                mid = (begin + end) // 2
                if d[mid] == e[1]:
                    return mid
                elif d[mid] < e[1]:
                    begin = mid + 1
                else:
                    end = mid
            return begin
            
        dp = []
        length = 0 
        for i, env in enumerate(envelopes):
            idx = getidx(env, dp, length)
            if idx == length:
                dp.append(env[1])
                length += 1
            else:
                dp[idx] = env[1]
        
        return length