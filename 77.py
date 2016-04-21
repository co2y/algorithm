class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []
        nums = [i for i in range(1,n+1)]
        
        def dfs(nums, path, res):
            if len(path) == k:
                res.append(path)
            for i in range(len(nums)):
                dfs(nums[i+1:],path+[nums[i]],res)
        
        dfs(nums, [], res)
        
        return res
        
    