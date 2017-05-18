# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        from collections import deque
        d = deque()
        d.append(root)
        d.append('#')
        row = -0xFFFFFFFF
        ans = []
        while d:
            now = d.popleft()
            if now == '#':
                ans.append(row)
                row = -0xFFFFFFFF
                if d:
                    d.append('#')
            else:
                row = max(row, now.val)
                if now.left:
                    d.append(now.left)
                if now.right:
                    d.append(now.right)

        return ans
