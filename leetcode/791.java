class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Character> indexMap = new HashMap<>();
        
        for (int i = 0; i < S.length(); ++i) {
            indexMap.put(S.charAt(i), (char)('z' + i + 1));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch : T.toCharArray()) {
            if (indexMap.containsKey(ch)) {
                sb.append(indexMap.get(ch));
            } else {
                sb.append(ch);
            }
        }
        
        char[] chs = sb.toString().toCharArray();
        Arrays.sort(chs);
        sb.delete(0, sb.length());
        for (char ch : chs) {
            if (ch > 'z') {
                sb.append(S.charAt(ch - 'z' - 1));
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}