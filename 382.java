/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private int l = 0;
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();
        int xx = r.nextInt(l);
        ListNode temp = head;
        for(int i=0; i<xx; ++i)
            temp =temp.next;
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
