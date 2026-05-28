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

    public ListNode findKthNode(ListNode temp, int k) {
        int count = 1;

        while (temp != null) {
            if (count == k) {
                return temp;
            }

            temp = temp.next;
            count++;
        }

        return null;
    }

    public ListNode reverse(ListNode temp) {

        ListNode prev = null;
        ListNode front = null;

        while (temp != null) {

            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode kthNode = findKthNode(temp, k);

            if (kthNode == null) {

                if (prev != null) {
                    prev.next = temp;
                }

                break;
            }

            ListNode kthNodeNext = kthNode.next;
            kthNode.next = null;

            ListNode reversedHead = reverse(temp);

            if (temp == head) {
                head = reversedHead;
            } else {
                prev.next = reversedHead;
            }

            prev = temp;
            temp = kthNodeNext;
        }

        return head;
    }
}
