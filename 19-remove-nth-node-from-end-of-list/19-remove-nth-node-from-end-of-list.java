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
        //TDD 
        //nth node can be first, middle or last
        if(head == null){
            return head;
        }
        ListNode iterator = head;
        int size = 0;
        ListNode tail;
        while(iterator!=null){
            tail = iterator;
            iterator = iterator.next;
            size++;
        }
        if(n>size){
            return head;
        }
        
        iterator =  head;
        if(n==size){
            iterator = iterator.next;
            return iterator;
        } else {
            n = size+1-n;
            for(int i = 1;i<n-1;i++){
                iterator = iterator.next;
            }
        }
        ListNode nodeToDelete = iterator.next;
        if(nodeToDelete == null && n == 1){
            return null;
        }
        ListNode nodeAfterDeletePoint = nodeToDelete.next;
        iterator.next = nodeAfterDeletePoint;
        return head;
    }
}