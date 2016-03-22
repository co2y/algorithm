class Solution(object):
    def hIndex(self, citations):
        if not citations:
            return 0
        citations = sorted(citations)
        n = len(citations)
        
        for h in range(n,-1,-1):
            if h == 0:
                return 0
            if citations[n-h] >= h:
                return h