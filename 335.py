class Solution(object):
    def isSelfCrossing(self, x):
        """
        :type x: List[int]
        :rtype: bool
        """
        for i in range(3,len(x)):
            # Case 1: current line crosses the line 3 steps ahead of it
            if(x[i]>=x[i-2] and x[i-1]<=x[i-3]):
                return True;  
            # Case 2: current line crosses the line 4 steps ahead of it
            elif(i>=4 and x[i-1]==x[i-3] and x[i]+x[i-4]>=x[i-2]):
                return True; 
            # Case 3: current line crosses the line 5 steps ahead of it
            elif(i>=5 and x[i-2]>=x[i-4] and x[i]+x[i-4]>=x[i-2] and x[i-1]<=x[i-3] and x[i-1]+x[i-5]>=x[i-3]):
                return True;  
        
        
        return False
        
# Case 3 中， 和之前第6条线重合的情况也已经覆盖到。