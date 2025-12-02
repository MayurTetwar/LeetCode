class Solution {
    int n;
    int[] tree;
    public void build(int[] arr,int node,int st,int end){
        if(st==end){
            tree[node]=arr[st];
            return;
        }else{
            int mid=(st+end)>>1;
            build(arr,node<<1,st,mid);
            build(arr,(node<<1) | 1,mid+1,end);
            tree[node]=Math.max(tree[node<<1],tree[(node<<1)|1]);
        }
    }
    public int query(int node,int st,int end,int l,int r,int val){
        if(end<l || r<st)return -1;
        if(tree[node]<=val)return -1;
        if(st==end)return st;
        int mid=(st+end)>>1;
        int left=query(node<<1,st,mid,l,r,val);
        if(left!=-1)return left;
        int right=query(node<<1 | 1,mid+1,end,l,r,val);
        return right;
    }
    public int[] leftmostBuildingQueries(int[] arr, int[][] q) {
        n=arr.length;
        tree=new int[4*n];
        build(arr,1,0,n-1);
        int[] ans=new int[q.length];
        for(int i=0;i<q.length;i++){
            int left=Math.min(q[i][0],q[i][1]);
            int right=Math.max(q[i][0],q[i][1]);
            if(left==right){
                ans[i]=left;
            }else if(arr[left]<arr[right]){
                ans[i]=right;
            }else{
                ans[i]=query(1,0,n-1,right+1,n-1,arr[left]);
            }
        }
        return ans;
    }
}