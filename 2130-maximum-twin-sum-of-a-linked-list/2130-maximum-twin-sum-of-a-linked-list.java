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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(fast != null && fast.next != null){
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        
        ListNode head2 = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = temp;
        }
        int res = 0;
        while(head != null){
            int sum = head.val + head2.val;
            res = Math.max(res , sum);
            head = head.next;
            head2 = head2.next;
        }

        return res;

    }
}