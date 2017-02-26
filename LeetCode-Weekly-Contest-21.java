// 530. Minimum Absolute Difference in BST

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
    private ArrayList<Integer> order = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        getorder(root);
        int ans = order.get(order.size()-1) - order.get(0);
        for (int i=1; i<order.size(); ++i) {
            ans = Math.min(ans, order.get(i)-order.get(i-1));
        }
        return ans;
    }

    private void getorder(TreeNode root) {
        if (root == null) return;
        getorder(root.left);
        order.add(root.val);
        getorder(root.right);
    }
}

// 523. Continuous Subarray Sum

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n+1];
        for (int i=1; i<=n; ++i) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        for (int i=0; i<=n; ++i) {
            for (int j=i+2;j<=n;++j) {
                if ((sums[j]-sums[i])==0 && k==0) return true;
                if ((sums[j]-sums[i])!=0 && k==0) continue;
                if ((sums[j]-sums[i]) % k == 0) return true;
            }
        }

        return false;
    }
}

// 524. Longest Word in Dictionary through Deleting
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        int n=s.length();
        int max = 0;
        String maxstring = "";
        for (String ss: d) {
            int m = ss.length();
            if (m>n) continue;

            if (m>max && judge(s,ss)) {
                max = m;
                maxstring = ss;
            }
        }
        return maxstring;
    }

    private boolean judge(String s, String ss) {
        int i=0;
        int j=0;
        while (j<ss.length() && i<s.length()) {
            if (s.charAt(i) != ss.charAt(j)) i++;
            else {
                i++;
                j++;
            }
        }
        return j==ss.length()?true:false;
    }
}

// 529. Minesweeper

// DFS 8个方向 
