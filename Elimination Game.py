class Solution(object):
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = True;
        remaining = n;
        step = 1;
        head = 1;
        while remaining > 1:
            if left or remaining % 2 ==1:
                head = head + step

            remaining = remaining / 2
            step = step * 2
            left = not left

        return head
