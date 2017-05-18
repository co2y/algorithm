class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        l = len(prices)
        if l == 0 or l==1:
            return 0
        
        sells = [0] * l
        buys = [0] * l
        
        sells[0] = 0 
        sells[1] = max(0, prices[1] - prices[0]) 
        buys[0] = -prices[0] 
        buys[1] = max(-prices[0], -prices[1])
        

        for i in range(2, l):
            sells[i] = max(sells[i - 1], buys[i - 1] + prices[i]) 
            buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
        
        return sells[-1]