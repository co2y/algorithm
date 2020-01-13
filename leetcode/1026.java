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
    private int ans = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        findAns(root, root.val);
        return ans;
    }
    
    NodeInfo findAns(TreeNode node, int v) {
        if (node == null) {
            return new NodeInfo(v, v);
        }
        
        NodeInfo l = findAns(node.left, node.val);
        NodeInfo r = findAns(node.right, node.val);
        
        ans = Math.max(ans, Math.abs(node.val - Math.min(l.min, r.min)));
        ans = Math.max(ans, Math.abs(node.val - Math.max(l.max, r.max)));
        
        
        return new NodeInfo(Math.max(node.val, Math.max(l.max, r.max)), Math.min(node.val, Math.min(l.min, r.min)));
    }
    
    
    private class NodeInfo {
        int max;
        int min;
        
        NodeInfo(int m, int n) {
            max = m;
            min = n;
        }
    }
}