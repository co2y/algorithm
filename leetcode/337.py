# wrong
def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
            
        count = 0
        root.parent = None
        
        from collections import deque
        visit_queue = deque()
        visit_queue.append(root)
        while visit_queue:
            now = visit_queue.popleft()
            if now.left:
                now.left.parent = count
                visit_queue.append(now.left)
            if now.right:
                now.right.parent = count
                visit_queue.append(now.right)
            count += 1
                
        dp = [[0]*2 for i in range(count)] 
        visit_queue = deque()
        visit_queue.append(root)
        dp[0][0] = 0
        dp[0][1] = root.val
        count = -1
        while visit_queue:
            count += 1
            now = visit_queue.popleft()
            if now.left:
                visit_queue.append(now.left)
            if now.right:
                visit_queue.append(now.right)
            if now.parent is not None:
                dp[count][0] = max(dp[now.parent][0], dp[now.parent][1])
                dp[count][1] = dp[now.parent][0] + now.val
                
        return max(dp[-1][0],dp[-1][1])

#short answer
class Solution(object):
    def rob(self, root):
        def solve(root):
            if not root:
                return 0, 0
            left, right = solve(root.left), solve(root.right)
            return (root.val + left[1] + right[1]), (max(left) + max(right))
        return max(solve(root))