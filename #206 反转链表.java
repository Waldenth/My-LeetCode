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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left>=right)
            return head;

        ListNode exHead=new ListNode(-1,head);
        ListNode leftNode=exHead,rightNode=exHead,preNode=exHead,succNode=exHead;
        ListNode tmpNode=exHead;

        int i=0;
        while(i<right){
            if(i==left-1){
                preNode=tmpNode;
                leftNode=tmpNode.next;
            }
            if(i==right-1){
                rightNode=tmpNode.next;
                succNode=rightNode.next;
            }
            
            tmpNode=tmpNode.next;
            i++;
        }        
        
        reverseList(leftNode,succNode,leftNode.next);
        
        preNode.next=rightNode;
        leftNode.next=succNode;

        return exHead.next;
    }
    private ListNode reverseList(ListNode listPreNode,ListNode listSuccNode,ListNode curNode){
        ListNode curPreNode=listPreNode;
        ListNode curSuccNode=null;
        while(curNode!=listSuccNode){
            curSuccNode=curNode.next;
            curNode.next=curPreNode;
            curPreNode=curNode;
            curNode=curSuccNode;
        }
        return curPreNode;
    }
}