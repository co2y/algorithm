public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hs.containsKey(c)) {
                hs.put(c, hs.get(c) + 1);
            } else {
                hs.put(c, 0);
            }
        }

        List<Map.Entry<Character, Integer>> l = new ArrayList<>(hs.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> mm : l) {
            for (int i = 0; i <= mm.getValue(); ++i) {
                sb.append(mm.getKey());
            }
        }
        return sb.toString();
    }
}
