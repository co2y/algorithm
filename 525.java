// MLE
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0)
                dp[i][i] = -1;
            else
                dp[i][i] = 1;
        }

        int res = 0;
        for (int i = n-2; i >=0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if(nums[i] == 0)
                    dp[i][j] = dp[i+1][j] - 1;
                if (nums[i] == 1)
                    dp[i][j] = dp[i+1][j] + 1;
                if (dp[i][j] == 0)
                    res = Math.max(res, j-i+1);
            }
        }
        return res;
    }
}


// TLE
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0)
                dp[i] = -1;
            else
                dp[i] = 1;
        }

        int res = 0;
        for (int i = n-2; i >=0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if(nums[i] == 0)
                    dp[j] = dp[j] - 1;
                if (nums[i] == 1)
                    dp[j] = dp[j] + 1;
                if (dp[j] == 0)
                    res = Math.max(res, j-i+1);
            }
        }
        return res;
    }
}


public class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum[i + 1] = sum[i] - 1;
            } else {
                sum[i + 1] = sum[i] + 1;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<>());
            }
            map.get(sum[i]).add(i);
        }
        int answer = 0;
        for (List<Integer> list : map.values()) {
            answer = Math.max(answer, list.get(list.size() - 1) - list.get(0));
        }
        return answer;
    }
}
