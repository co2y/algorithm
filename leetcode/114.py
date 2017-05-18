# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root :
            return
        
        preorder = []
        def pre_order(node):
            preorder.append(node)
            pre = node
            if node.left is not None:
                pre_order(node.left)
            node = pre
            if node.right is not None:
                pre_order(node.right)
                
        pre_order(root)
        for index,eachnode in enumerate(preorder[:-1]):
            preorder[index].left = None
            preorder[index].right = preorder[index+1]