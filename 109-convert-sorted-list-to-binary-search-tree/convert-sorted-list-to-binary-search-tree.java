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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // -10 -3 -1 0 5 9 
        return helper(head);
    }
    public TreeNode helper(ListNode head){
        if(head==null)return null;
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null){
            fast=fast.next;
            prev=slow;
            slow=slow.next;
            if(fast==null)break;
            fast=fast.next;
        }
        TreeNode curr=new TreeNode(slow.val);
        prev.next=null;
        curr.left=helper(head);
        curr.right=helper(slow.next);
        return curr;
    }
}