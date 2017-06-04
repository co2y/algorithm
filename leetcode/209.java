public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        LinkedList<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        int res = n+1;
        for (int i=0; i<n; ++i) {
            sum += nums[i];
            deque.add(nums[i]);
            ans++;
            if (sum >= s) {
                int temp = deque.getFirst();
                while (sum - temp >= s) {
                    deque.removeFirst();
                    sum -= temp;
                    ans--;
                    temp = deque.getFirst();
                }
                res = Math.min(res, ans);
            }
        }

        return sum>=s?res:0;
    }
}
