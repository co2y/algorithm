/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));    
 
         int currentLevelNodeCnt = 1;
         int nextLevelNodeCnt = 0;
         int max = currentLevelNodeCnt;
         int start = 1;
         int end = 1;
         while(!queue.isEmpty()) {
             Pair p = queue.poll();
             TreeNode current = p.node;
             end = p.index;
             if (current.left != null) {
                 queue.add(new Pair(current.left, 2*end));
                 nextLevelNodeCnt++;
             }
             if (current.right != null) {
                 queue.add(new Pair(current.right, 2*end+1)); 
                 nextLevelNodeCnt++;      
             }               
             if(--currentLevelNodeCnt == 0) {
                 max = max > (end - start + 1) ? max : (end - start + 1);
                 currentLevelNodeCnt = nextLevelNodeCnt;
                 nextLevelNodeCnt = 0;
                 start = queue.isEmpty() ? -1 : queue.peek().index;
             }
         }	
        return max;
    }
    
    private static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode n, int i) {
            node = n;
            index = i;
        }
    }
}
