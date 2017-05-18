/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) return "";
        stack.addLast(root);

        while (stack.size() > 0) {
            TreeNode now = stack.pollLast();
            sb.append(now.val);
            sb.append(",");
            if (now.right != null) stack.add(now.right);
            if (now.left != null) stack.add(now.left);

        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nums = data.split(",");
        LinkedList<Integer> queue = new LinkedList<>();
        for (String num : nums) queue.add(Integer.valueOf(num));
        return getNode(queue);
    }

    private TreeNode getNode(LinkedList<Integer> queue) {
        if (queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        LinkedList<Integer> left = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            left.add(queue.poll());
        }

        root.left = getNode(left);
        root.right = getNode(queue);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
