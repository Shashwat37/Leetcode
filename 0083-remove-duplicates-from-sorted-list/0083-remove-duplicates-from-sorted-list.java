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
    public ListNode deleteDuplicates(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head;
        int index = 0;

        while (temp != null) {
            if (!map.containsKey(temp)) {
                map.put(temp, index);
                index++;
            }
            temp = temp.next;
        }

        ListNode[] arr = new ListNode[map.size()];

        int i = 0;
        for (ListNode node : map.keySet()) {
            arr[i] = node;
            i++;
        }

        for (i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].val > arr[j + 1].val) {
                    ListNode t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }

        ListNode newHead = null;
        ListNode tail = null;

        for (i = 0; i < arr.length; i++) {

            if (i > 0 && arr[i].val == arr[i - 1].val) {
                continue;
            }

            arr[i].next = null;

            if (newHead == null) {
                newHead = arr[i];
                tail = arr[i];
            } else {
                tail.next = arr[i];
                tail = arr[i];
            }
        }

        return newHead;
    }
}