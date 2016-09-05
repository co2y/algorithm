class Solution(object):
	def majorityElement(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		if not nums:
			return

		now = nums[0]
		count = 1

		for num in nums[1:]:
			if count == 0:
				now = num
				count = 1
			else:
				if num == now:
					count += 1
				else:
					count -= 1

		return now