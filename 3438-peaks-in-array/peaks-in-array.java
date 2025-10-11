class Solution {
    int[] tree;
    int n;
    int[] arr;
    public int isPeak(int idx) {
        if (idx <= 0 || idx >= n - 1) {
            return 0;
        }
        return (arr[idx] > arr[idx - 1] && arr[idx] > arr[idx + 1]) ? 1 : 0;
    }
    public List<Integer> countOfPeaks(int[] arr, int[][] que) {
        n = arr.length;
        tree=new int[4*n];
        this.arr=arr;
        int[] p=new int[n];
        for(int i=1;i<n-1;i++){
            p[i]=isPeak(i);
        }
        build(p,1,0,n-1);
        List<Integer> ans=new ArrayList<>();
        // System.out.println(query(0,n-1));
        for(int[] q:que){
            if(q[0]==1){
                int li = q[1];
                int ri = q[2];
                if (li + 1 > ri - 1) {
                    ans.add(0);
                } else {
                    ans.add(query(li + 1, ri - 1));
                }
            }else{
                int ind=q[1];
                int val=q[2];
                arr[ind]=val;
                if(ind-1>=1 && ind<n){
                    int peek=isPeak(ind-1);
                    if(p[ind-1]!=peek){
                        p[ind-1]=peek;
                        update(ind-1,peek);
                    }
                }
                if(ind>=1 && ind<n-1){
                    int peek=isPeak(ind);
                    if(p[ind]!=peek){
                        p[ind]=peek;
                        update(ind,peek);
                    }
                }
                if(ind>=0 && ind+1<n-1){
                    int peek=isPeak(ind+1);
                    if(p[ind+1]!=peek){
                        p[ind+1]=peek;
                        update(ind+1,peek);
                    }
                }
            }
        }
        return ans;
    }
    public void build(int[] p,int node,int st,int end){
        if(st==end){
            tree[node]=p[st];
        }else{
            int mid=st+(end-st)/2;
            build(p,node*2,st,mid);
            build(p,node*2+1,mid+1,end);
            tree[node]=tree[2*node]+tree[2*node+1];
        }
    }
    public int query(int l,int r){
        return query(1,0,n-1,l,r);
    }
    public int query(int node,int st,int end,int l,int r){
        if(r<st || end<l)return 0;
        if(l<=st && end<=r){
            return tree[node];
        }
        int mid=st+(end-st)/2;
        int left=query(node*2,st,mid,l,r);
        int right=query(node*2+1,mid+1,end,l,r);
        return left+right;
    }
    public void update(int ind,int val){
        update(1,0,n-1,ind,val);
    }
    public void update(int node,int st,int end,int ind,int val){
        if(st==end){
            tree[node]=val;
        }else{
            int mid = (st + end) / 2;
            if (ind <= mid) {
                update(2 * node, st, mid, ind, val);
            } else {
                update(2 * node + 1, mid + 1, end, ind, val);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }
}
