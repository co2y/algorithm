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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // O(h) space solution
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
    
        pushLeft(s1, root1);
        pushLeft(s2, root2);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> currentStack =  (s2.isEmpty() || (!s1.isEmpty() && s1.peek().val < s2.peek().val)) ? s1 : s2; // S1 or S2
            TreeNode node = currentStack.pop();
            ans.add(node.val);
            pushLeft(currentStack, node.right);
        }


        return ans;
    }

    private void pushLeft(Stack<TreeNode> s, TreeNode node) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }
}