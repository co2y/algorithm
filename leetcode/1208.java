class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        int n = sch.length;
        int[] cost = new int[n];
        for(int i = 0; i <n; ++i) {
            cost[i] = Math.abs(sch[i] - tch[i]);
        }
        
        int ans = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            while (!q.isEmpty() && cost[i] > maxCost) {
                int f = q.poll();
                maxCost += cost[f];
            }
            if (cost[i] <= maxCost) {
                q.offer(i);
                maxCost -= cost[i];
                ans = Math.max(ans, q.size());
            }
        }
        
        return ans;
    }
}