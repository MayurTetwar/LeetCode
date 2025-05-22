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
    // public ListNode mergeKLists(ListNode[] arr) {
        
    // }
    static void merge(ListNode head,int start,int mid,int end){
        ListNode temp=head;
        for(int i=0;i<=mid;i++){
            temp=temp.next;
        }
        ListNode temp2=temp;
        temp=head;
        while(temp!=null && temp2!=null && temp!=temp2){
            if(temp.val>temp2.val){
                int t=temp.val;
                temp.val=temp2.val;
                temp2.val=t;
            }
            temp=temp.next;
        }
    }
    static void mergeSort(ListNode temp,int start,int end){
        if(start>=end) return;
        int mid=(start+end)/2;
        mergeSort(temp,start,mid);
        mergeSort(temp,mid+1,end);
        merge(temp,start,mid,end);
    }
    public ListNode mergeKLists(ListNode[] arr) {
        ListNode ans=null;
        int len=arr.length;
        int i=0;
        if(len==0){
            return ans;
        }
        while(i<len && arr[i]==null ){
            i++;
        }
        if(i>=len){
            return ans;
        }
        ans=arr[i];
        ListNode temp=arr[i];
        int lenLar=0;
        for(i=i+1;i<=len;i++){
            while(temp.next!=null){
                temp=temp.next;
                lenLar++;
            }
            if(i==len)
                break;
            temp.next=arr[i];
        }
        mergeSort(ans,0,lenLar);
        return ans;
    }
}