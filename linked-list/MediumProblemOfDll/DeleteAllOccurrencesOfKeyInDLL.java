/*Definition of doubly linked list:
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
 */

class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {

        ListNode temp = head;

        while (temp != null) {

            ListNode nextNode = temp.next;

 if (temp.val == target) {
          if (temp == head) {
                    head = head.next;
                }
         if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
         if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                temp.next = null;
                temp.prev = null;
            }

            temp = nextNode;
        }

        return head;
    }
}
