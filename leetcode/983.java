class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int[] dp = new int[366];
        dp[0] = 0;
        for (int day = 1; day <= 365; ++day) {
            if (!set.contains(day)) {
                dp[day] = dp[day - 1];
                continue;
            }
            int min = dp[day - 1] + costs[0];
            min = Math.min(min, dp[Math.max(0, day - 7)] + costs[1]);
            min = Math.min(min, dp[Math.max(0, day - 30)] + costs[2]);
            dp[day] = min;
        }

        return dp[365];
    }
}