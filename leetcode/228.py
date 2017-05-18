class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []
        head = pre = nums[0]
        result = []
        for cur in nums[1:]:
            if cur == pre + 1:
                pre = cur
            else:
                if head == pre:
                    result.append(str(head))
                else:
                    result.append(str(head)+ "->" + str(pre))
                head = pre = cur
        if head == pre:
            result.append(str(head))
        else:
            result.append(str(head)+ "->" + str(pre))
        return result