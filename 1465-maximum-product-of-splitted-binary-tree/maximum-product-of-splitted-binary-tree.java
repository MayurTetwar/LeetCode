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
    long max;
    long mod=1000000007;
    public int maxProduct(TreeNode root) {
        long sum=dfs(root);
        max=0;
        dfs2(root,sum);
    //    System.out.println(max);
        return (int)(max%mod);
    }
    public long dfs2(TreeNode root,long total){
        if(root==null)return 0;
        long left=dfs2(root.left,total);
        long right=dfs2(root.right,total);
        max=Math.max(max,(total-left)*left);
        max=Math.max(max,(total-right)*right);
      //  System.out.println(root.val+" "+(total-left)*left+" "+(total-right)*right);
       return left+right+root.val;
    }
    public long dfs(TreeNode root){
        if(root==null)return 0;
        return dfs(root.left)+dfs(root.right)+root.val;
    }
}