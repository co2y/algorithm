class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        int[] vis = new int[n];
        vis[0] = 1;
        
        dfs(rooms, vis, 0);
        
        for (int v: vis) {
            if (v == 0) return false;
        }
        
        return true;
    }
    
    void dfs(List<List<Integer>> rooms, int[] vis, int now) {
        List<Integer> keys = rooms.get(now);
        
        for (int key : keys) {
            if (vis[key] == 0) {
                vis[key] = 1;
                dfs(rooms, vis, key);
            }
        }
    }
}