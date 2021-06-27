package leetcode;

/**
 * Given the head of a linked list and an integer val, remove all the nodes
 * of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {
     class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode buff;

            if (head == null) {
                return null;
            }

            while (head.val == val) {
                head = head.next;
                if (head == null) {
                    return null;
                }
            }

            buff = head;

            while (buff.next != null) {
                if (buff.next.val == val) {
                    buff.next = buff.next.next;
                } else {
                    buff = buff.next;
                }
            }

            return head;
        }
    }
}
