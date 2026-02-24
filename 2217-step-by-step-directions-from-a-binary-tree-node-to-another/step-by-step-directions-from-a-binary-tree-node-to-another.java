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
    int[] depth;
    int[] path;
    public String getDirections(TreeNode root, int p, int q) {
        depth=new int[100001];
        path=new int[100001];
        dfs(root,1,p,q);
        // System.out.println(Arrays.toString(depth));
        // System.out.println(Arrays.toString(path));

        while(true){
            if(root.left!=null && path[root.left.val]==3){
                root=root.left;
            }else if(root.right!=null && path[root.right.val]==3){
                root=root.right;
            }else{
                break;
            }
        }
        // System.out.println(root.val);
        // for(int i=1;i<=8;i++){
        //     System.out.println(i+" "+depth[i]+" "+path[i]);
        // }

        StringBuilder sb=new StringBuilder();
        for(int i=depth[root.val];i<depth[p];i++){
            sb.append('U');
        }
        
        while(true){
            if(root.left!=null && path[root.left.val]==2){
                sb.append('L');
                root=root.left;
            }else if(root.right!=null && path[root.right.val]==2){
                sb.append('R');
                root=root.right;
            }else{
                break;
            }
        }
        return sb.toString();
    }
    public int dfs(TreeNode root,int level,int p,int q){
        if(root==null)return 0;
        depth[root.val]=level;
        int left=dfs(root.left,level+1,p,q);
        int right=dfs(root.right,level+1,p,q);

        if(left==3 || right==3)return path[root.val]=3;

        if(left!=0 && right!=0){
            return path[root.val]=3;
        }else if(left!=0 || right!=0){
            if(root.val==p || root.val==q)path[root.val]=3;
            else if(left!=0)path[root.val]=left;
            else path[root.val]=right;
            return path[root.val];
        }
        if(root.val==p)return path[root.val]=1;
        if(root.val==q)return path[root.val]=2;
        return 0;
    }
}