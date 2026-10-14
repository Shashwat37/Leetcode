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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;

        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }

        if (cnt < k) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head.next = reverseKGroup(cur, k);

        return prev;
    }
}