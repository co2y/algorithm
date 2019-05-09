class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && m.get(s.charAt(i)) > m.get(s.charAt(i-1))) {
                ans = ans - m.get(s.charAt(i-1)) * 2;
            }
            ans += m.get(s.charAt(i));
        }
        return ans;
    }
}




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Stack<Integer> s1 = new Stack<>();
//         while (l1 != null) {
//             s1.add(l1.val);
//             l1 = l1.next;
//         }
        
//         Stack<Integer> s2 = new Stack<>();
//         while (l2 != null) {
//             s2.add(l2.val);
//             l2 = l2.next;
//         }
        
        ListNode ret = new ListNode(0);
        ListNode now = ret;
        int c = 0;

        while (l1 != null && l2 != null) {
            int t1 = l1.val;
            int t2 = l2.val;
            now.next = new ListNode((t1+t2+c)%10);
            c = (t1+t2+c)/10;
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int t1 = l1.val;
            now.next = new ListNode((t1+c)%10);
            c = (t1+c)/10;
            now = now.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int t2 = l2.val;
            now.next = new ListNode((t2+c)%10);
            c = (t2+c)/10;
            now = now.next;
            l2 = l2.next;
        }
        
        
        if (c > 0) {
            now.next = new ListNode(c);
        }
        
        return ret.next;
    }
}