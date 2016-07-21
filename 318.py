# TLE
class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        def ok(a, b):
            sa = set(a)
            sb = set(b)
            if len(sa) < len(sb):
                for each in sa:
                    if each in sb:
                        return False
            else:
                for each in sb:
                    if each in sa:
                        return False
            return True
                
        r = 0
        l = len(words)
        for i in xrange(l):
            for j in xrange(i+1,l):
                if len(words[i])*len(words[j]) > r and ok(words[i], words[j]):
                    r = len(words[i])*len(words[j])
                    
        return r
        
# ok 
class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        d = {}
        for w in words:
            mask = 0
            for c in set(w):
                mask |= (1 << (ord(c) - 97))
            d[mask] = max(d.get(mask, 0), len(w))
        return max([d[x] * d[y] for x in d for y in d if not x & y] or [0])
        