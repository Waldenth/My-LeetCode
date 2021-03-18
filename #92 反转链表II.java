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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right)
            return head;
        
        ListNode exHead=new ListNode(-1,head);

        LinkedList<ListNode>stack=new LinkedList<>();

        ListNode curNode=exHead;
        int curIndex=0;

        for(;curIndex<left-1;curIndex++)
            curNode=curNode.next;

        ListNode swapListPreNode=curNode;

        while(curIndex<right){
            curNode=curNode.next;
            curIndex++;
            stack.addLast(curNode);
        }
        
        ListNode swapListNextNode=curNode.next;

        ListNode swapListFirstNode=stack.pollLast();
        ListNode swapListLastNode=swapListFirstNode;
        ListNode tmpNode=null;

        while(stack.size()!=0){
            tmpNode=stack.pollLast();
            swapListLastNode.next=tmpNode;
            swapListLastNode=tmpNode;
        }

        swapListLastNode.next=swapListNextNode;
        swapListPreNode.next=swapListFirstNode;

        return exHead.next;
    }
}