class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int c : hand) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > 0) {
                int key = entry.getKey();
                for (int i = W - 1; i >= 0; --i) {
                    int checkKey = key + i;
                    if (map.getOrDefault(checkKey, 0) < value) return false;
                    map.put(checkKey, map.get(checkKey)-value);
                }
            }
        }
        
        return true;
    }
}