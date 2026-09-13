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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (n == cnt) {
            return head.next;
        }
        int k = cnt - n;
        temp = head;
        int c = 1;
        while (temp != null) {
            if (c == k) {
                temp.next = temp.next.next;
                break;
            }
            c++;
            temp = temp.next;
        }

        return head;
    }
}