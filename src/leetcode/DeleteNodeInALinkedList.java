package leetcode;

/**
 * Write a function to delete a node in a singly-linked list.
 * You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 *
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class DeleteNodeInALinkedList {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public void deleteNode(ListNode node) {

            ListNode buff = node;

            while (node.next != null) {
                buff.val = node.val;
                node.val = node.next.val;
                node.next.val = buff.val;
                if (node.next.next == null) break;
                node = node.next;
            }

            node.next = null;
        }
    }

    /**
     * Improved solution
     */

    class Solution2 {
        public void deleteNode(ListNode node) {

            ListNode buff = node;

            while (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) break;
                node = node.next;
            }

            node.next = null;
        }
    }
}
