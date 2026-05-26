class Solution {
   public ListNode  reverse(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode prev = null;
    ListNode temp = head;
    ListNode front = head;
    while(temp != null){
        front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }
return prev;
   }
    public ListNode addOne(ListNode head) {
      head =  reverse(head);
      int carry = 1;
      ListNode temp = head;

      while(carry != 0 && temp!= null){
         if(temp.val == 9 ){
            temp.val = 0;
         }else{
            temp.val++;
            carry = 0;
         }
         temp = temp.next;
      }

      head = reverse(head);

if(carry == 1){
    ListNode newNode = new ListNode(1);
    newNode.next = head;
    head = newNode;
}

return head;

    }
}
