class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; ++i){
            nums[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; ++i){
            pq.add(nums[i][0]);
            sum += nums[i][0];
            if(pq.size() > k){
                sum -= pq.poll();
            }
            ans = Math.max(ans, sum*nums[i][1]);
        }
        return (int)(ans % 1000000007);
    }
}