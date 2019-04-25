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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }
    
    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }
        
        Pair<Integer, TreeNode> l = deep(root.left);
        Pair<Integer, TreeNode> r = deep(root.right);

        int d1 = l.getKey();
        int d2 = r.getKey();
        
        return new Pair(Math.max(d1, d2) + 1, 
                        d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
    
    private static class Pair<K, V> {
        K key;
        V value;
        Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }
        
        K getKey() {
            return key;
        }
        
        V getValue() {
            return value;
        }
    }
}