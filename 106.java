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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i=0; i<inorder.length; ++i) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright, Map<Integer, Integer>hm){
        if (inleft>inright || postleft>postright) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postright]);
        int index = hm.get(postorder[postright]);
        TreeNode leftchild = buildTreePostIn(inorder, inleft, index-1, postorder, postleft, postleft+index-1-inleft, hm);
        TreeNode rightchild = buildTreePostIn(inorder, index+1, inright, postorder, postleft+index-1-inleft+1, postright-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
