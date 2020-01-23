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
    
    Map<TreeNode, Integer> map = new HashMap<>();
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }
    
    private int find(TreeNode current, TreeNode target) {
        if (current == null) return -1;
        
        if (current == target) {
            map.put(current, 0);
            return 0;
        }
        
        int left = find(current.left, target);
        if (left != -1) {
            map.put(current, left + 1);
            return left + 1;
        }
        
		int right = find(current.right, target);
		if (right != -1) {
            map.put(current, right + 1);
            return right + 1;
        }
        
        return -1;
    }
    
    private void dfs(TreeNode current, TreeNode target, int K, int length, List<Integer> res) {
        if (current == null) return;
        
        if (map.containsKey(current)) length = map.get(current);
        
        if (length == K) res.add(current.val);
        
        dfs(current.left, target, K, length + 1, res);
        dfs(current.right, target, K, length + 1, res);
    }
    
}