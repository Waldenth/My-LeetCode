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
    public ListNode reverseList(ListNode head) {
        ListNode preNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            ListNode succNode=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=succNode;
        }
        return preNode;
    }
}