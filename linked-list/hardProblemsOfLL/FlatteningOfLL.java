/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
class Solution {

public ListNode merge(ListNode list1 , ListNode list2){
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;
    ListNode t1 = list1;
    ListNode t2 = list2;
    while(t1 != null && t2 != null){
        if(t1.val< t2.val){
            temp.child = t1;
            t1 = t1.child;
        }else{
            temp.child = t2;
            t2 = t2.child;
        }
        temp = temp.child;
        temp.next = null;
    }
    if(t1 != null) {
        temp.child = t1;
    }else {
        temp.child = t2;
    }
    return dummy.child;
}


    public ListNode flattenLinkedList(ListNode head) {
    if(head == null || head.next == null){
        return head;
    }
    ListNode mergedHead = flattenLinkedList(head.next);
    return merge(head,mergedHead);
    }
}
