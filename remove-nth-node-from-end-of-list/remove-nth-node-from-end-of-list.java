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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode xAhead, x=null;
        xAhead = head;
        for(int i=1;xAhead!=null && i<=n;i++){
            xAhead = xAhead.next;
        }
        if(xAhead == null){
            return head.next;
        }
        x = head;
        while(xAhead.next!=null){
            xAhead = xAhead.next;
            x = x.next;
        }
        
        x.next = x.next.next;
        return head;
    }
}