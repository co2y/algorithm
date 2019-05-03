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
    private boolean change = true;
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode node = root;
        if (root == null) {
            return null;
        }
        while (true) {
            if (node == null) {
                break;
            }
                
            if (node.val < L) {
                node = node.right;
            } else if (node.val > R) {
                node = node.left;
            } else {
                break;
            }
        }
        
        helper(node, L, R);
        return node;
            
    }
    
    
    void helper(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        change = true;
        while (change) {
            change = false;
            trim(root, L, R);
        }
        helper(root.left, L, R);
        helper(root.right, L, R);
    }
    
    void trim(TreeNode root, int L, int R) {
        if (root.left != null && root.left.val < L) {
            root.left = root.left.right;
            change = true;
        }
        if (root.right != null && root.right.val > R) {
            root.right = root.right.left;
            change = true;
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode l1 = L1;
        ListNode l2 = L2;
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        
        while (l1 != null) {
            n1.add(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            n2.add(l2.val);
            l2 = l2.next;
        }
        
        
        
        int c = 0;
        List<Integer> n3 = new ArrayList<>();
        int now = 1;
        int s = Math.min(n1.size(), n2.size());
        for (; now <= s; ++now) {
            int tmp = c + n1.get(n1.size()-now) + n2.get(n2.size()-now);
            if (tmp >= 10) {
                c = 1;
                tmp = tmp - 10;
            } else {
                c = 0;
            }
            n3.add(tmp);
        }
        
        if (now <= n1.size()) {
            for (int i = now; i <= n1.size(); ++i) {
                int tmp = c + n1.get(n1.size() - i);
                if (tmp >= 10) {
                    c = 1;
                    tmp = tmp - 10;
                } else {
                    c = 0;
                }
                n3.add(tmp);
            }
        }
        
        
        if (now <= n2.size()) {
            for (int i = now; i <= n2.size(); ++i) {
                int tmp = c + n2.get(n2.size() - i);
                if (tmp >= 10) {
                    c = 1;
                    tmp = tmp - 10;
                } else {
                    c = 0;
                }
                n3.add(tmp);
            }
        }
        
        if (c > 0) {
            n3.add(c);
        }
        
        ListNode head = new ListNode(0);
        ListNode t = head;
        
        for (int i = n3.size()-1; i >= 0; --i) {
            int num = n3.get(i);
            // System.out.println(num);
            t.next = new ListNode(num);
            t = t.next;
        }
        
        return head.next;
    }
}