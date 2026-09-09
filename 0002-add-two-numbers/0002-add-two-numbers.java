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
      

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(t1 != null || t2 != null || carry != 0){
        int sum = 0;
        if(t1 != null){
            sum += t1.val;
        }
        if(t2 != null){
            sum += t2.val;
        }
        sum += carry;
        ListNode newNode = new ListNode(sum%10);
        carry = sum/10;
        temp.next = newNode;
        temp = temp.next;
        t1 = t1 == null ? null : t1.next;
        t2 = t2 == null ? null : t2.next;
        }
   


         return dummy.next;
    }
}