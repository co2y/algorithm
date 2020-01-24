class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];    
            };
        });
        
        int total = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];    
            };
        });
        
        for (int[] c : courses) {
            if (total + c[0] <= c[1]) {
                total += c[0];
                pq.offer(c);
            } else {
                if (pq.size()>0 && pq.peek()[0] > c[0]) {
                    int[] tmp = pq.poll();
                    total -= tmp[0];
                    pq.offer(c);
                    total += c[0];
                }
            }
        }
        
        return pq.size();
    }
}