class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int e[] : edges) {
            List<Integer> subs = map.getOrDefault(e[0], new ArrayList<>());
            subs.add(e[1]);
            map.put(e[0], subs);
            
            List<Integer> subs2 = map.getOrDefault(e[1], new ArrayList<>());
            subs2.add(e[0]);
            map.put(e[1], subs2);
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 1});
        int[] p = new int[n];
        int[] vis = new int[n+1];
        vis[1] = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == target) {
                if ( (check(target, map, vis) && now[1] <=t) || now[1] == t)
                    return 1.0 / now[2];
                else {
                    return 0;    
                }
            }

            if (now[1] > t) break;
            
            List<Integer> subs = map.getOrDefault(now[0], new ArrayList<>());
            
            int size = 0;
            for (int sub: subs) {
                if (vis[sub] == 0) size++;
            }
            
            if (size == 0) continue;

            for (int sub : subs) {
                if (vis[sub] == 1) continue;
                vis[sub] = 1;
                
                q.offer(new int[]{sub, now[1]+1, now[2]*size});
            }
            
        }
        
        return 0;
    }
    
    private boolean check(int t, Map<Integer, List<Integer>> map, int[] vis) {
        int size = 0;
        List<Integer> subs = map.getOrDefault(t, new ArrayList<>());
        for (int sub: subs) {
            // System.out.println(sub + " " + vis[sub]);
            if (vis[sub] == 0) size++;
        }
        
        return size == 0;
    }
}