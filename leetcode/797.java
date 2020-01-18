class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        int[] vis = new int[n];
        
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, vis, ans, 0, path, n-1);
        
        return ans;
    }
    
    
    private void dfs(int[][] graph, int[] vis, List<List<Integer>> ans, int next, LinkedList<Integer> path, int target) {
        if (next == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int n : graph[next]) {
            if (vis[n] == 0) {
                vis[n] = 1;
                path.add(n);
                dfs(graph, vis, ans, n, path, target);
                path.removeLast();
                vis[n] = 0;
            }
        }
    }
}