public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int now = 0;
        int ans = 0;
        for (int time: timeSeries) {
            if (time >= now) {
                now = time + duration;
                ans = ans + duration;
            }
            else {
                ans = ans + time + duration - now;
                now = time + duration;
            }
        }
        return ans;
    }
}
