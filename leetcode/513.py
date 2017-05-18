# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def getlength(node):
            if node is None:
                return 0
            return max(getlength(node.left), getlength(node.right)) + 1

        find = [False]
        ans = [root.val]

        def getans(node, step):
            if find[0]:
                return
            if node is None:
                return
            if step == deep:
                find[0] = True
                ans[0] = node.val

            getans(node.left, step + 1)
            getans(node.right, step + 1)

        deep = getlength(root)
        getans(root, 1)
        return ans[0]
