/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode n1 = head, n2 = head;
        
        while (n2 != null) {
            n2 = n2.next;
            if (n2 == null) break;
            n2 = n2.next;
            n1 = n1.next;
        }
        
        return n1;
    }
}