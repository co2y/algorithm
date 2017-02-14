# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.ans = []
        self.curr = 0
        self.count = 0
        self.maxcount = 0
        self.inorder1(root)
        self.count = 0
        self.inorder2(root)
        return self.ans

    def inorder1(self, node):
        if not node:
            return
        self.inorder1(node.left)
        self.handle1(node.val)
        self.inorder1(node.right)

    def inorder2(self, node):
        if not node:
            return
        self.inorder2(node.left)
        self.handle2(node.val)
        self.inorder2(node.right)

    def handle1(self, val):
        if val != self.curr:
            self.curr = val
            self.count = 0
        self.count += 1
        if self.count > self.maxcount:
            self.maxcount = self.count

    def handle2(self, val):
        if val != self.curr:
            self.curr = val
            self.count = 0
        self.count += 1
        if self.count == self.maxcount:
            self.ans.append(val)
