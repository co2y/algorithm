#### A
```
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        
        
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[").append(ch).append("]");
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
```

#### B
```
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        
        
        for (int[] book : bookings) {
            int i = book[0];
            int j = book[1];
            
            int k = book[2];
            
            
            for (int x = i; x <= j; ++x) {
                ans[x-1] += k;
            }
        }
        
        return ans;
    }
}
```

#### C
```
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new LinkedList<TreeNode>();
        }
        
        Set<Integer> del = new HashSet<>();
        for (int d : to_delete) {
            del.add(d);
        }
        
        
        Set<TreeNode> ans = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ans.add(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) continue;            
            
            if (del.contains(node.val)) {
                ans.add(node.left);
                ans.add(node.right);
            }
            
            if (node.left != null) {
                
                if (del.contains(node.left.val)) {
                    
                    TreeNode tmp = new TreeNode(node.left.val);
                    tmp.left = node.left.left;
                    tmp.right = node.left.right;
                    ans.add(tmp.left);
                    ans.add(tmp.right);
                    q.add(tmp);
                    
                    node.left = null;
                } else {
                    q.add(node.left);
                }
            }
            
            if (node.right != null) {
                
                if (del.contains(node.right.val)) {
                    
                    TreeNode tmp = new TreeNode(node.right.val);
                    tmp.left = node.right.left;
                    tmp.right = node.right.right;
                    ans.add(tmp.left);
                    ans.add(tmp.right);
                    q.add(tmp);
                    
                    node.right = null;
                } else {
                    q.add(node.right);
                }
            }
            
        }
        
        
        
        return ans.stream().filter(x -> x!=null).filter(x -> !del.contains(x.val)).collect(Collectors.toList());
    }
}
```

#### D

```
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int d = findMaxDepth(seq);
        
        System.out.println(d);
        int target = (d+1) / 2;
        
        int n = seq.length();
        
        int[] ans = new int[n];
        int tmp = 0;
        char[] chs = seq.toCharArray();
        for (int i = 0; i < n; ++i) {
            char ch = chs[i];
            if (ch == '(') {
                tmp++;
                
                if (tmp > target) {
                    ans[i] = 1;
                } else {
                    ans[i] = 0;
                }
                
            } else {
                
                if (tmp > target) {
                    ans[i] = 1;
                } else {
                    ans[i] = 0;
                }
                
                tmp--;
                
            }
        }
        
        return ans;
        
    }
    
    private int findMaxDepth(String s) {
        int ans = 0;
        int now = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                now++;
                if (now > ans) {
                    ans = now;
                }
            } else {
                now--;
            }
        }
        
        return ans;
    }
}
```