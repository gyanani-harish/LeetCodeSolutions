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
    //using prev pointer without O(n) spacce
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;//1
        ListNode nextNode = head.next;//2
        while(nextNode!=null){
            current.next = prev;//1->null, 2->1, 3->2, 4->3
            prev = current;//1, 2, 3, 4
            current = nextNode;//2, 3, 4, 5
            nextNode = current.next;//3, 4, 5, null
        }
        current.next = prev;
        return current;
    }
    //space O(n), time O(n)
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        head.next = stack.pop();
        ListNode headNext = head.next;
        
        while(!stack.isEmpty()){
            headNext.next = stack.pop();
            headNext = headNext.next;
        }
        headNext.next = null;
        return head;
    }
}