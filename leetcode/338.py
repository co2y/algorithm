class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num == 0:
            return [0]
            
        numofone = [0] * (num+1)
        #numofone[1] = 1
        
        power = 0
        while 2**power <= num:
            start = 2**power
            end = 2**(power+1) - 1
            ptr = start
            
            while ptr<=end and ptr<=num:
                numofone[ptr] = numofone[ptr-start]+1
                ptr+=1
            
            power += 1
            
        return numofone
            