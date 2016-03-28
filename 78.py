# 求子集  可以递归，可以dp，可以dfs，可以位操作

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        self.dfs(nums, 0, [], res)
        return res
    
    def dfs(self, nums, start, path, res):
        res.append(path)
        for i in range(start, len(nums)):
            self.dfs(nums, i+1, path+[nums[i]], res)

            
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        l = [[]]
        if nums is None:
            return l
        nums.sort()
        l.append([nums[0]])

        for i in range(1, len(nums), 1):
            lenl = len(l)
            for j in range(0,lenl,1):
                tmp = l[j]+[nums[i]]
                l.append(tmp)
        return l


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
    result  = []
    numsSorted = sorted(nums)
    for i in range(1 << len(nums)):
        j = 0
        cur = []

        while j <= i:
            if (1 << j) & i != 0:
                cur.append(numsSorted[j])
            j+=1
        result.append(cur)

    return result
