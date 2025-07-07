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
        ListNode pp=new ListNode(-1000);
        ListNode res=pp;
        pp.next=head;
        ListNode prev=head;
        while(prev!=null && prev.next!=null){
            int val=prev.val;
            ListNode temp=prev.next;
            boolean flag=false;
            while(temp!=null && temp.val==val){
                temp=temp.next;
                flag=true;
            }
            if(flag){
                pp.next=temp;
                prev=temp;
            }else{
                pp=prev;
                prev=prev.next;
            }
        }
        return res.next;
    }
}