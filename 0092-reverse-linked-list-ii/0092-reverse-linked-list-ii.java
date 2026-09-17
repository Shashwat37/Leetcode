/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        ListNode prev = null;

        for (int i = 1; i < left; i++) {
            prev = temp;
            temp = temp.next;
        }

        ListNode first = temp;

        for (int i = left; i <= right; i++) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode newHead = stack.pop();

        if (prev == null)
            head = newHead;
        else
            prev.next = newHead;

        ListNode curr = newHead;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        curr.next = temp;
        return head;
    }
}
