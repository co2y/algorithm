class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        numdict = {}
        
        for i in range(10):
            numdict[str(i)] = 0
            
        for each in secret:
            numdict[each] += 1
            
        a = 0
        b = 0
        
        l = len(guess)
        for i in range(l):
            if guess[i] == secret[i]:
                a += 1
                numdict[guess[i]] -= 1
        for i in range(l):
            if guess[i] != secret[i] and numdict[guess[i]] > 0:
                numdict[guess[i]] -= 1
                b += 1
        return str(a)+'A'+str(b)+'B'
            