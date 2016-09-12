class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        
        num = range(n+1)  
        self.num=num[1:]
        for i in range(k-1):
            self.nextPermutation()
        return ''.join(str(e) for e in self.num)
        
    def nextPermutation(self):
        j,k=len(self.num)-2,len(self.num)-1
        while j >= 0:
            if self.num[j] < self.num[j+1]: break
            j -= 1

        if j < 0:return False
        
        while k > j :
            if self.num[k] > self.num[j]:   break
            k -= 1
          
        self.num[j],self.num[k]=self.num[k],self.num[j]    
        self.num=self.num[:j+1]+self.num[:j:-1]
        return True
        
        
def getPermutation(self, n, k):
    elements = range(1, n+1)
    NN = reduce(operator.mul, elements) # n!
    k, result = (k-1) % NN, ''
    while len(elements) > 0:
        NN = NN / len(elements)
        i, k = k / NN, k % NN
        result += str(elements.pop(i))
    return result