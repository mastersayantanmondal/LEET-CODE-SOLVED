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
        // Initialize a dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of the current nodes or 0 if null
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // Add the current digit to the result list
            current.next = new ListNode(sum % 10);

            // Move to the next node
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the next node after the dummy as the head of the result list
        return dummy.next;
    }
}
