class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        buy_price, profit = prices[0], 0
        for price in prices:
            buy_price = min(buy_price, price)
            profit = max(profit, price - buy_price)
        return profit
