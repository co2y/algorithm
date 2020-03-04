class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = Profits.length;
        
        for (int i = 0; i < n; ++i) {
            if (W >= Capital[i]) {
                pq.offer(Profits[i]);
            } else {
                pq2.offer(new int[]{i, Capital[i]});
            }
        }
        
        
        for (int i = 0; i < k; ++i) {
            if (pq.isEmpty()) break;
            
            int o = pq.poll();
            W += o;
        
            while (!pq2.isEmpty() && pq2.peek()[1] <= W) {
                int[] o2 = pq2.poll();
                pq.offer(Profits[o2[0]]);
            }
        }
        
        return W;
    }
}