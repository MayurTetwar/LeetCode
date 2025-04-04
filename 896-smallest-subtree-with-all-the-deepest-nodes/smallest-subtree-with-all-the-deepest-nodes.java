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
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth=getDepth(root);
        int leafNode=getLeftNode(root,depth,1);
        // System.out.println(leafNode+" "+depth);
        helper(root,depth,1,leafNode);
        return ans;
    }
     public int helper(TreeNode root,int depth,int height,int leafNode){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
          //  System.out.println(depth+" "+height);
            if(depth==height){
                if(leafNode==1){
                    ans=root;
                    return -1000;
                }
                return 1;
            }
            return 0;
        }
        int val=helper(root.left,depth,height+1,leafNode)+helper(root.right,depth,height+1,leafNode);
        if(val==leafNode){
            //System.out.println(root.val);
            ans=root;
            return -1000;
        }
        return val;
    }
    public int getDepth(TreeNode root){
        if(root==null)return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
    public int getLeftNode(TreeNode root,int depth,int height){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
          //  System.out.println(depth+" "+height);
            if(depth==height)return 1;
            return 0;
        }
        return getLeftNode(root.left,depth,height+1)+getLeftNode(root.right,depth,height+1);
    }
}