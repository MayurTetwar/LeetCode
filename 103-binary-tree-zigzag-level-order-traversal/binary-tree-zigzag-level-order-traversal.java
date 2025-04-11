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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        int depth=getDepth(root,0);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<depth;i++){
            list.add(new ArrayList<>());
        }
        //System.out.println(depth);
        //list.get(0).add(root.val);
        helper(root,list,0);
        return list;
    }
    public void helper(TreeNode root,List<List<Integer>> list,int depth){
        if(root==null)return;
        if(depth%2==0)list.get(depth).add(root.val);
        else list.get(depth).add(0,root.val);
        helper(root.left,list,depth+1);
        helper(root.right,list,depth+1);
    }
    public int getDepth(TreeNode root,int depth){
        if(root==null)return depth;
        return Math.max(getDepth(root.left,depth+1),getDepth(root.right,depth+1));
    }
}