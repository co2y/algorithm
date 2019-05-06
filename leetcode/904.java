class Solution {
    public int totalFruit(int[] tree) {
        int n = tree.length;
        int first = 0;
        int second = 0;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        
        while (second < n) {
            cnt.put(tree[second], cnt.getOrDefault(tree[second], 0) + 1);
            
            while (cnt.size() > 2) {
                
                cnt.put(tree[first], cnt.getOrDefault(tree[first], 0) - 1);
                if (cnt.get(tree[first]) == 0) {
                    cnt.remove(tree[first]);
                }
                
                first++;
            }
            
            second++;
            ans = Math.max(ans, second-first);
        }
        
        
        return ans;

    }
}