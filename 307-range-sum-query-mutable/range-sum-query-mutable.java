class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] arr) {
        n=arr.length;
        tree=new int[n*4];
        build(0,n-1,1,arr);
    }
    public void build(int l,int r,int node,int[] arr){
        if(l==r){
            tree[node]=arr[r];
        }else{
            int mid=(l+r)/2;
            build(l,mid,node*2,arr);
            build(mid+1,r,node*2+1,arr);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }
    public int query(int l,int r,int left,int right,int node){
        if(right<l || r<left)return 0;
        if(left<=l && r<=right){
            return tree[node];
        }
        int mid=(l+r)/2;
        int ls=query(l,mid,left,right,node*2);
        int rs=query(mid+1,r,left,right,node*2+1);
        return ls+rs;
    }
    public void update(int l,int r,int node,int idx,int val){
        if(l==r){
            tree[node]=val;
        }else{
            int mid=(l+r)/2;
            if(idx<=mid){
                update(l,mid,node*2,idx,val);
            }else{
                update(mid+1,r,node*2+1,idx,val);
            }
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }
    public void update(int index, int val) {
        // System.out.println(Arrays.toString(tree));
        update(0,n-1,1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return query(0,n-1,left,right,1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */