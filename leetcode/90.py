class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        ll = len(nums)
        
        def dfs(now, remain, l):
            if now not in result:
                result.append(now)
            for i in range(l):
                dfs(now+[remain[i]], remain[i+1:], len(remain[i+1:]))
            
        
        dfs([], nums, ll)
        return result
        
# much better
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        ll = len(nums)
        
        def dfs(now, remain, l):
            result.append(now)
            for i in range(l):
                if i!=0 and remain[i]==remain[i-1]:
                    continue
                dfs(now+[remain[i]], remain[i+1:], len(remain[i+1:]))
            
        
        dfs([], nums, ll)
        return result