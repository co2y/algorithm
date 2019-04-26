class Solution:
    def distributeCandies(self, candies: List[int]) -> int:
        s = set(candies)
        
        return len(s) if len(s) < len(candies) // 2 else len(candies) // 2
        