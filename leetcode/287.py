class Solution(object):

    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow = fast = finder = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                while finder != slow:
                    finder = nums[finder]
                    slow = nums[slow]
                return finder
