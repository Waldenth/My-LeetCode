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
    public ListNode deleteDuplicates(ListNode head) {
        Deque<ListNode>stack=new ArrayDeque<>();
        ListNode curNode=head;
        ListNode res=null;
        int curRepeatVal=Integer.MAX_VALUE;
        while(curNode!=null){
            if(stack.size()==0){
                if(curNode.val!=curRepeatVal)
                    stack.addLast(curNode);
            }else{
                ListNode tmp=stack.peekLast();
                //System.out.println(tmp.val +" "+curNode.val+" "+curRepeatVal);
                if(tmp.val==curNode.val){
                    curRepeatVal=curNode.val;
                    stack.pollLast();
                }else if(curNode.val==curRepeatVal){

                }else{
                    stack.addLast(curNode);
                    //System.out.println("push");
                }
            }
            curNode=curNode.next;
        }
        //System.out.println(stack.size());
       Iterator<ListNode> iterator=stack.iterator();

       if(!iterator.hasNext()){
           return res;
       }
       res=iterator.next();
       res.next=null;
       ListNode preNode=res;
       while(iterator.hasNext()){
           //System.out.println(preNode.val);
           preNode.next=iterator.next();
           preNode=preNode.next;
       }
        preNode.next=null;
        return res;
    }
}