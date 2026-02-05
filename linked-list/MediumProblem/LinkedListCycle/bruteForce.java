/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

    List<ListNode> L = new ArrayList<>();
    ListNode temp = head;

    while (temp != null) {

        if (L.contains(temp)) return true;

        L.add(temp);
        temp = temp.next;
    }

    return false;
}
}
