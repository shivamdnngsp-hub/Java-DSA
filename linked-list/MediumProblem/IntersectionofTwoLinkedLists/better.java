public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int count1 = 0;
        int count2 = 0;

        ListNode t1 = headA;
        ListNode t2 = headB;

        while (t1 != null) {
            count1++;
            t1 = t1.next;
        }

        while (t2 != null) {
            count2++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        int diff = Math.abs(count1 - count2);

        if (count1 > count2) {

            for (int i = 0; i < diff; i++) {
                t1 = t1.next;
            }

        } else {

            for (int i = 0; i < diff; i++) {
                t2 = t2.next;
            }
        }

        while (t1 != null && t2 != null) {

            if (t1 == t2) {
                return t1;
            }

            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
    }
}
