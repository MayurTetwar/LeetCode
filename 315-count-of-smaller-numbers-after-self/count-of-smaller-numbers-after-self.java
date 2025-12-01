class Solution {
    int n;
    ArrayList<Integer>[] tree;

    void build(int[] arr,int node,int st,int end){
        tree[node]=new ArrayList<>();
        if(st==end){
            tree[node].add(arr[st]);
        }else{
            int mid=(st+end)>>1;
            build(arr, node<<1, st, mid);
            build(arr, (node<<1) | 1, mid+1, end);
            tree[node].addAll(tree[node<<1]);
            tree[node].addAll(tree[(node<<1)|1]);
            Collections.sort(tree[node]);
        }
    }

    int countLE(int node,int st,int end,int l,int r,int val){
        if(end<l || r<st)return 0;
        if(l<=st && end<=r)return upperBound(tree[node],val);
        int mid=(st+end)>>1;
        return countLE(node<<1,st,mid,l,r,val)+countLE(node<<1 | 1,mid+1,end,l,r,val);
    }
    int upperBound(ArrayList<Integer> list,int val){
        int st=0,end=list.size();
        while(st<end){
            int mid=(st+end)>>1;
            if(list.get(mid)<val)st=mid+1;
            else end=mid;
        }
        return st;
    }
    public List<Integer> countSmaller(int[] arr) {
        n=arr.length;
        tree=new ArrayList[4*n];
        build(arr,1,0,n-1);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(countLE(1,0,n-1,i+1,n-1,arr[i]));
        }
        return ans;
    }
}