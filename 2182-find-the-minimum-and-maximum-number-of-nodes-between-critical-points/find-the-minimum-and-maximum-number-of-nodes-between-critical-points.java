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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr={-1,-1};
        if(head.next.next==null){
            return arr;
        }
        ListNode cur=head.next;
        int currInd=1;
        int firstInd=-1;
        int secInd=-1;
        int min=100000;
        int max=-1;
        while(cur.next!=null){
            if((head.val<cur.val && cur.val>cur.next.val)||(head.val>cur.val && cur.val<cur.next.val)){
                if(firstInd==-1){
                    firstInd=currInd;
                }else{
                    if(secInd==-1)
                        min=currInd-firstInd;
                    else{
                        min=Integer.min(min,currInd-secInd);
                    }
                    secInd=currInd;
                }
            }
            currInd++;
            cur=cur.next;
            head=head.next;
        }
        if(firstInd==-1 || secInd==-1){
            return new int[]{-1,-1};
        }
        max=secInd-firstInd;
        return new int[]{min,max};
    }
}