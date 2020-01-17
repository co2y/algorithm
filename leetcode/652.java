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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        
        postorder(root, map, res);
        
        return res;
    }
    
    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) {
            return "#";  
        }
        
        // String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res); yes
        // String serial = postorder(cur.left, map, res) + "," + cur.val + "," + postorder(cur.right, map, res); no
        String serial = postorder(cur.left, map, res) + "," + postorder(cur.right, map, res) + "," + cur.val;
        
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(cur);
        }
        
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}