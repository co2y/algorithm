class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        from collections import Counter
        from functools import reduce
        
        c = Counter(deck)
        divs = []
        for cc in c:
            divs.append(c[cc])
        
        def gcd(a, b):
            if a < b:
                a, b = b, a
            while b != 0:
                a,b = b,a%b
            return a
        
        print(divs)
        return reduce(gcd, divs) > 1