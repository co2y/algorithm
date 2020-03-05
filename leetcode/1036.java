class Solution {
    int[][] steps = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        Set<String> b = new HashSet<>();
        for (int[] block: blocked) b.add(block[0]+","+block[1]);
        
        return bfs(blocked, source, target,b) &&  bfs(blocked, target, source,b);
        
    }
    
    private boolean bfs(int[][] blocked, int[] source, int[] target, Set<String> b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        Set<String> s = new HashSet<>();
        s.add(source[0]+","+source[1]);
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] step :steps) {
                int x = step[0] + now[0];
                int y = step[1] + now[1];
                if (x==target[0] && y==target[1]) return true;
                int[] next = new int[]{x,y};
                
                if (x<0 || y<0 || x==1000000 || y==1000000 || s.contains(x+","+y) || b.contains(x+","+y)) {
                    continue;
                }
                s.add(x+","+y);
                q.offer(next);
            }
            
            if (s.size()>20000) return true;
        }
        
        return false;
    }
}