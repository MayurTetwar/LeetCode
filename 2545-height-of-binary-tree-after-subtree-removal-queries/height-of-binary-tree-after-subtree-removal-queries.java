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
    int[] arr;
    int[] in;
    int[] out;
    int[] tree;
    int timer=0;
    public void dfs(TreeNode root,int level){
        arr[timer]=level;
        in[root.val]=timer;
        timer++;
        if(root.left!=null){
            dfs(root.left,level+1);
        }
        if(root.right!=null){
            dfs(root.right,level+1);
        }
        out[root.val]=timer-1;
    }
    public void build(int node,int st,int end){
        if(st==end){
            tree[node]=arr[st];
        }else{
            int mid=(st+end)/2;
            build(node*2,st,mid);
            build(node*2+1,mid+1,end);
            tree[node]=Math.max(tree[node*2],tree[node*2+1]);
        }
    }
    public int query(int node,int st,int end,int l,int r){
        if(end<l || r<st)return -1;
        if(l<=st && end<=r)return tree[node];
        int mid=(st+end)/2;
        int left=query(node*2,st,mid,l,r);
        int right=query(node*2+1,mid+1,end,l,r);
        return Math.max(left,right);
    }
    public int[] treeQueries(TreeNode root, int[] que) {
        arr=new int[100005];
        in=new int[100005];
        out=new int[100005];
        tree=new int[400005];
        
        dfs(root,0);
        int n=timer;
        build(1,0,n-1);
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        int[] ans=new int[que.length];
        int i=0;
        for(int node:que){
            int left=query(1,0,n-1,0,in[node]-1);
            int right=query(1,0,n-1,out[node]+1,n-1);
            // System.out.println(left+" "+right);
            ans[i++]=Math.max(left,right);
        }
        return ans;
    }
}