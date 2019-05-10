class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(2);
        
        for (int num : nums) {
            if (m.size() < 2) {
                m.put(num, m.getOrDefault(num, 0) + 1);
            } else {
                if (m.containsKey(num)) {
                    m.put(num, m.get(num) + 1);
                } else {
                    Set<Integer> keys = m.keySet();
                    for (Integer k : keys) {
                        m.put(k, m.get(k)-1);
                    }
                    m.entrySet().removeIf(x -> x.getValue() == 0);
                }
            }
        }
        
        List<Integer> ans = new LinkedList<>();
        for (Integer k : m.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == k) {
                    count++;
                }
            }
            if (count > nums.length / 3) {
                ans.add(k);
            }
        }
        return ans;
    }
}