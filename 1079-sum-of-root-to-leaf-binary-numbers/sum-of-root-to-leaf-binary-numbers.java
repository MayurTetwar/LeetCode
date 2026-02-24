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
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int val){
        if(root.left==null && root.right==null){
            val=(val<<1)|root.val;
            sum+=val;
            return;
        }
        if(root.left!=null)helper(root.left,(val<<1)|root.val);
        if(root.right!=null)helper(root.right,(val<<1)|root.val);
    }
}