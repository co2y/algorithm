class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [amount+1] * (amount+1)
        dp[0] = 0
        for i in range(1, amount+1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i], dp[i-coin]+1)
        
        return dp[amount] if dp[amount] <= amount else -1
        

# BFS much faster
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        now = {0}
        vistied = {0}
        ans = 0
        
        while now:
            if amount in now:
                return ans
            
            now = {a+c for a in now for c in coins if a+c <= amount} - visited
            visited = visited | now
            ans += 1
        
        return -1