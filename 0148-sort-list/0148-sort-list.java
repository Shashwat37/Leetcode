class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode a = sortList(head);
        ListNode b = sortList(mid);

        ListNode d = new ListNode(0);
        ListNode p = d;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }

        if (a != null) {
            p.next = a;
        } else {
            p.next = b;
        }

        return d.next;
    }
}