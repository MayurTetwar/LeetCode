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
    int lev;
    public int maxLevelSum(TreeNode root) {
        Integer[] arr=new Integer[10002];
        lev=0;
        arr[0]=root.val;
        helper(root,arr,1);
        int max=Integer.MIN_VALUE;
        int ind=-1;
        for(int i=0;i<lev;i++){
            if(max<arr[i]){
                max=arr[i];
                ind=i;
            }
        }
        return ind+1;
    }
    public int helper(TreeNode root,Integer[] arr,int level){
        if(root==null)return 0;
        lev=Math.max(lev,level);
        int left=helper(root.left,arr,level+1);
        int right=helper(root.right,arr,level+1);
        if(arr[level]==null){
            arr[level]=left+right;
        }else{
            arr[level]+=left+right;
        }
        return root.val;
    }
}