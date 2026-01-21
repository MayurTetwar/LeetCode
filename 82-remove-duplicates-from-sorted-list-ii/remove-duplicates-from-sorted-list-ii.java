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
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode temp=head;

        head=prev;
        while(temp!=null){
            int val=temp.val;
            ListNode curr=temp;
            int cnt=0;
            while(temp!=null && val==temp.val){
                temp=temp.next;
                cnt++;
            }
            if(cnt==1){
                prev=curr;
            }else{
                prev.next=temp;
            }
          //  System.out.println(temp.val+" "+prev.val);
        //    temp=temp.next;
        }
        return head.next;
    }
}