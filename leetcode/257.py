# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        ans = []
        from collections import deque
        q = deque()
        if root:
            q.append((root, ))
        while q:
            temp = q.popleft()

            now = temp[-1]

            if now.left:
                q.append(temp + (now.left, ))
            if now.right:
                q.append(temp + (now.right, ))

            if not now.left and not now.right:
                ans.append(temp)

        ret = []
        for each in ans:
            temp = map(lambda x: str(x.val), each)
            ret.append("->".join(temp))
        return ret
