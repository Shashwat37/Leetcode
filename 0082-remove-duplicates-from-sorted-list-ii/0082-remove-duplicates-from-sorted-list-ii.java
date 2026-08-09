class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;

        ListNode p = d;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int x = p.next.val;

                while (p.next != null && p.next.val == x) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }

        return d.next;
    }
}