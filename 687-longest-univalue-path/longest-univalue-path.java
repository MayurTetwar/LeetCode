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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans=0;
        if(root==null)return 0;
        int x=helper(root,root.val);
        //ans=Math.max(ans,x);
        return ans;
    }
    public int helper(TreeNode root,int val){
        if(root==null)return 0;
        int x=helper(root.left,root.val);
        int y=helper(root.right,root.val);
        ans=Math.max(ans,x+y);
        x=Math.max(x,y);
        //System.out.println(i+" "+arr[i]);
        if(val==root.val)return x+1;
        return 0;
    }
}