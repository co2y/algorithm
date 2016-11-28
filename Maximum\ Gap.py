class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return 0
        a, b = min(nums), max(nums)
        if a == b:
            return 0

        size = int(math.ceil(float(b - a) / (len(nums) - 1)))

        bucket = [[None, None] for _ in range((b - a) // size + 1)]
        for n in nums:
            b = bucket[(n - a) // size]
            b[0] = n if b[0] is None else min(b[0], n)
            b[1] = n if b[1] is None else max(b[1], n)
        bucket = [b for b in bucket if b[0] is not None]
        return max(bucket[i][0] - bucket[i - 1][1]
                   for i in range(1, len(bucket)))
