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
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int posFromStart = count - n + 1;
        if (posFromStart == 1) {
            head = head.next;
            return head;
        }
        temp = head;
        count = 1;
        while (temp != null) {
            if (count == posFromStart - 1) {
                temp.next = temp.next.next;
                break;
            }
            count++;
            temp = temp.next;

        }
        return head;
    }
}
