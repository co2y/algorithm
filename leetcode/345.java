public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('A');
        set.add('e');set.add('E');
        set.add('i');set.add('I');
        set.add('o');set.add('O');
        set.add('u');set.add('U');
        int left = 0;
        int right = s.length()-1;
        char[] chs = s.toCharArray();
        while(left < right) {
            while (!set.contains(chs[left]) && left<right) left++;
            while (!set.contains(chs[right]) && left<right) right --;
            if (left >= right) break;
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chs);
    }
}
