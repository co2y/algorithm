class Solution {
    
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        
        
        long[] sum = new long[1];
        
        wall.forEach(w -> {
            int[] index = new int[1];
            
           w.forEach(ww -> {
               sum[0] = sum[0] + ww;;
               index[0] = index[0] + ww;
               int tmp = hm.getOrDefault(index[0], 0);
               hm.put(index[0], tmp+1);
           });
        });
        
        int[] m = new int[1];
        hm.entrySet().stream().forEach(e -> {
            //System.out.println(e.getKey() + " " +e.getValue());
            if (e.getKey() != sum[0]/wall.size()) {
                m[0] = Math.max(e.getValue(), m[0]);
            }
        });
        
        return wall.size() - m[0];
    }
}