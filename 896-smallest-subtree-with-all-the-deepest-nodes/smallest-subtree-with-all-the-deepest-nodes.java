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
    int count;
    int height;
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height = getheight(root);
        count = dfs(root,1);
        ans = null ;
        dfs2(root,1);
        return ans;
    }
    public int dfs2(TreeNode root,int level){
        if(root==null){
            return 0;
        }
        int add=0;
        if(height==level)add=1;
        int left=dfs2(root.left,level+1);
        int right=dfs2(root.right,level+1);
        if(left+right+add==count && ans==null){
            ans=root;
        }
        return left+right+add;
    }
    public int dfs(TreeNode root,int level){
        if(root==null)return 0;
        if(height==level)return 1;
        int left=dfs(root.left,level+1);
        int right=dfs(root.right,level+1);
        return left+right;
    }
    public int getheight(TreeNode root){
        if(root==null)return 0;
        int left=getheight(root.left)+1;
        int right=getheight(root.right)+1;
        return Math.max(left,right);
    }
}