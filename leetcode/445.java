/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        ListNode head1 = l1;
        ListNode head2 = l2;

        while (head1 != null) {
            stack1.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            stack2.add(head2);
            head2 = head2.next;
        }

        ListNode ans = new ListNode(0);


        int sum=0, plus=0;
        while (stack1.size() > 0 && stack2.size() > 0) {
            sum = stack1.pollLast().val + stack2.pollLast().val + plus;
            if (sum >= 10) {sum-=10; plus=1;}
            else {plus=0;}
            ListNode temp = new ListNode(sum);
            temp.next = ans.next;
            ans.next = temp;
        }


        while (stack1.size() > 0) {
            sum = stack1.pollLast().val + plus;
            if (sum >= 10) {sum-=10; plus=1;}
            else {plus=0;}
            ListNode temp = new ListNode(sum);
            temp.next = ans.next;
            ans.next = temp;
        }

        while (stack2.size() > 0) {
            sum = stack2.pollLast().val + plus;
            if (sum >= 10) {sum-=10; plus=1;}
            else {plus=0;}
            ListNode temp = new ListNode(sum);
            temp.next = ans.next;
            ans.next = temp;
        }

        if (plus > 0) {
            ListNode temp = new ListNode(plus);
            temp.next = ans.next;
            ans.next = temp;
        }

        return ans.next;
    }
}
