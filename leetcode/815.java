class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        
        if (S == T) {
            return 0;
        }
        
        int n = routes.length;
        int[] vis = new int[n];
        
        HashMap<Integer, Set<Integer>> station2Bus = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                station2Bus.putIfAbsent(routes[i][j], new HashSet<>());
                station2Bus.get(routes[i][j]).add(i);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int r = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {    
                for (int bus : station2Bus.get(q.poll()))
                    if (vis[bus] == 0) {
                        vis[bus] = 1;
                        for (int station = 0; station < routes[bus].length; station++) {
                            if (routes[bus][station] == T) {
                                return r;
                            }
                            else {
                                q.offer(routes[bus][station]);
                            }
                        }
                    }
            }
            r++;
        }
        return -1;
    }
}