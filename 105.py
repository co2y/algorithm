# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return
        
        node = TreeNode(preorder[0])
        node_index = inorder.index(preorder[0])
        preorder.pop(0)
        node.left = self.buildTree(preorder, inorder[0:node_index])
        node.right = self.buildTree(preorder, inorder[node_index+1:])
        return node


# 卵用slice会MLE 例如
if inorder:
        node = TreeNode(preorder[0])
        node_index = inorder.index(preorder[0])
        l_len = len(inorder[:node_index])
        node.left = self.buildTree(preorder[1:l_len+1], inorder[0:l_len])
        node.right = self.buildTree(preorder[l_len+1:], inorder[l_len+1:])
        return node
        
# ac
if inorder:
        node = TreeNode(preorder[0])
        node_index = inorder.index(preorder[0])
        preorder.pop(0)
        l_len = len(inorder[:node_index])
        node.left = self.buildTree(preorder, inorder[0:l_len])
        node.right = self.buildTree(preorder, inorder[l_len+1:])
        return node