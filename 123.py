class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0

        buy_price, profit = prices[0], 0

        days = len(prices)
        left = [i for i in range(days)]
        for i in range(days):
            buy_price = min(buy_price, prices[i])
            profit = max(profit, prices[i] - buy_price)
            left[i] = profit

        ret = left[-1]
        buy_price = prices[-1]
        sells = prices[-1]
        for i in range(days - 1, -1, -1):
            buy_price = prices[i]
            sells = max(sells, prices[i])
            ret = max(ret, left[i] + sells - buy_price)
        return ret
