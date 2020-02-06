class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private Random rand = new Random();
    private int m;

    public Solution(int n, int[] blacklist) {
        
        for (int b : blacklist) {
            map.put(b, 0);
        }
            
        m = n - map.size();

        for (int b : blacklist) {
            if (b < m) {
                while (map.containsKey(n-1)) {
                    n--;
                }
                map.put(b, n-1);
                n--;
            }
        }
    }
    
    public int pick() {
        int next = rand.nextInt(m);
        if (map.containsKey(next)) {
            return map.get(next);
        }
        return next;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */