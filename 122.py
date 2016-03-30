class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)
        buy = 0
        ans = 0
        oper = []
        for i in range(length - 1):
            if prices[i+1] > prices[i] and buy == 0:
                buy = 1
                oper.append(i)
            if prices[i+1] < prices[i] and buy == 1:
                buy = 0
                oper.append(i)
            if oper and prices[i+1] > prices[oper[-1]] and i+1 == length-1:
                oper.append(i+1)
        len2 = len(oper)
        print oper
        
        for i in range(0,len2-1,2):
            ans = ans + prices[oper[i+1]] - prices[oper[i]]
       
        return ans