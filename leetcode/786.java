// 1,2,3,5

// [1,5] [1,3] [1,2]
// [2,5] [2,3]
// [3,5]

class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return A[o1[0]] * A[o2[1]] - A[o2[0]] * A[o1[1]];
            }
        });
        
        for (int i = 0; i < n-1; i++) {
            pq.add(new int[]{i, n-1});
        }
        
        for (int i = 0; i < K-1; i++) {
            int[] pop = pq.poll();
            
            if (pop[1] - 1 > pop[0]) {
                pop[1] = pop[1] - 1;
                pq.offer(pop);
            }
        }

        int[] peek = pq.peek();
        
        return new int[]{A[peek[0]], A[peek[1]]};
    }
}