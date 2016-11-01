class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        ans = []
        l = len(candidates)

        def dfs(path, s, index):
        	if s == target:
        		temp = path[:]
        		ans.append(temp)
        	else:
        		if s < target:
        			for i in range(index, l):
        				if i > index and candidates[i] == candidates[i-1]:
        					continue
        				path.append(candidates[i])
        				dfs(path, s+candidates[i], i+1)
        				path.pop()

        	

        dfs([], 0, 0)
        return ans


s = Solution()
print s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
