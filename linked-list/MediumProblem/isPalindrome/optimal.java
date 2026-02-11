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
    public ListNode reverse(ListNode head){
 if(head == null) return null;
        if(head.next == null) return head;
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
          if(head == null) return true;
ListNode slow = head;
ListNode fast = head;
        while( fast.next != null && fast.next.next != null){
fast = fast.next.next;
slow = slow.next;
        }

ListNode  newHead = reverse(slow.next);
ListNode temp = head;
ListNode temp2 = newHead;

        while(temp2 != null){
        if(temp.val != temp2.val){
        slow.next = reverse(newHead);
        return false;
        }
          temp2 = temp2.next;
         temp = temp.next;
        }
slow.next = reverse(newHead);
        return true;
    }
}
