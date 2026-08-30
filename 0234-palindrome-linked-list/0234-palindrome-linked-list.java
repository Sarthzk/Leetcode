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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while(fast != null && fast.next != null){
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode prev1 = null;

        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev1;
            prev1 = slow;
            slow = temp;

        }
        while(head != null){
            if(head.val != prev1.val) return false;
            head = head.next;
            prev1 = prev1.next;
        }
        return true;   
    }
}