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
    public int maxPathSum(TreeNode root) {
        // for(int i=0;i<3*1000;i++){
        //     System.out.print(-1000+",");
        // }
        ans=Integer.MIN_VALUE;
        int x=helper(root);
        return Math.max(x,ans);
    }
    public int helper(TreeNode root){
        if(root==null){
            return -1000000;
        }
        int suml=helper(root.left);
        int sumr=helper(root.right);
        // System.out.println(suml+" "+sumr+" "+root.val);
        ans=Math.max(ans,Math.max(suml,sumr));
        ans=Math.max(ans,suml+sumr+root.val);
        return Math.max(root.val,root.val+Math.max(suml,sumr));
    }
}