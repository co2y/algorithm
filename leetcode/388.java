class Solution {
    public int lengthLongestPath(String input) {
        int ans = 0;
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        hm.put(-1, 0);
        
        for (String s : input.split("\n")) {
            
            int l = s.lastIndexOf("\t") + 1;
            
            String name = s.substring(l);
             
            
            if (name.contains(".")) {
                ans = Math.max(ans, hm.get(l-1) + name.length());
            } else {
                hm.put(l, hm.get(l-1) + name.length() + 1);
            }
        }
        
        return ans;
    }
    
}