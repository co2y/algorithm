# https://discuss.leetcode.com/topic/15886/should-be-6-liner

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n == 0:
            return []
        
        def node(val, left, right):
            node = TreeNode(val)
            node.left = left
            node.right = right
            return node
            
        def trees(first, last):
            return [node(root, left, right)
                    for root in range(first, last+1)
                    for left in trees(first, root-1)
                    for right in trees(root+1, last)] or [None]
                    
        return trees(1, n)

def generateTrees(self, n):
    def generate(first, last):
        trees = []
        for root in range(first, last+1):
            for left in generate(first, root-1):
                for right in generate(root+1, last):
                    node = TreeNode(root)
                    node.left = left
                    node.right = right
                    trees += node,
        return trees or [None]
    return generate(1, n)