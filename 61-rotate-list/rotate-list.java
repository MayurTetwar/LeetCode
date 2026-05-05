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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
        int len=0;
        ListNode last=head;
        while(last.next!=null){
            len++;
            last=last.next;
        }
        len++;
        k=k%len;
        ListNode temp=head;
        for(int i=0;i<len-k-1;i++){
            temp=temp.next;
        }
        last.next=head;
        ListNode newhead=temp.next;
        temp.next=null;
        return newhead;
    }
}