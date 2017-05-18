/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        getAns(ans, root);
        return ans;
    }

    public void getAns(List<Integer> ans, TreeNode root) {
        if (root == null) return;

        getAns(ans, root.left);
        getAns(ans, root.right);
        ans.add(root.val);
    }
}
