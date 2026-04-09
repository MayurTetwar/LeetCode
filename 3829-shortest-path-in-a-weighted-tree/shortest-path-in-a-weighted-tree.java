class Solution {
    int[] arr,in,out,par;
    int n;
    int[] tree,lazy;
    int[] weight;
    List<List<int[]>> list;
    int timer=0;
    public void dfs(int curr,int p,int val,int w){
        in[curr]=timer;
        arr[timer]=val;
        weight[curr]=w;
        par[curr]=p;
        timer++;
        for(int[] ne:list.get(curr)){
            if(ne[0]==p)continue;
            dfs(ne[0],curr,val+ne[1],ne[1]);
        }
        out[curr]=timer-1;
    }
    public void build(int node,int st,int end){
        if(st==end){
            tree[node]=arr[st];
        }else{
            int mid=(st+end)/2;
            build(node*2,st,mid);
            build(node*2+1,mid+1,end);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }
    public void push(int node,int st,int end){
        if(lazy[node]!=0){
            tree[node]+=(end-st+1)*lazy[node];
            if(st!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
    }
    public int query(int node,int st,int end,int idx){
        push(node,st,end);
        if(st==end){
            return tree[node];
        }else{
            int mid=(st+end)/2;
            if(idx<=mid){
                return query(node*2,st,mid,idx);
            }else{
                return query(node*2+1,mid+1,end,idx);
            }
        }
    }
    public void update(int node,int st,int end,int l,int r,int val){
        if(end<l || r<st)return;
        push(node,st,end);
        if(l<=st && end<=r){
            lazy[node]+=val;
            push(node,st,end);
            return;
        }
        int mid=(st+end)/2;
        update(node*2,st,mid,l,r,val);
        update(node*2+1,mid+1,end,l,r,val);
        tree[node]=tree[node*2]+tree[node*2+1];
    }   

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        this.n=n;
        list=new ArrayList<>();
        par=new int[n];
        in=new int[n];
        arr=new int[n];
        out=new int[n];
        weight=new int[n];
        tree=new int[n*4];
        lazy=new int[n*4];

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        List<Integer> ans=new ArrayList<>();
        for(int[] e:edges){
            list.get(e[0]-1).add(new int[]{e[1]-1,e[2]});
            list.get(e[1]-1).add(new int[]{e[0]-1,e[2]});
        }

        dfs(0,-1,0,0);
        build(1,0,n-1);
        
        // System.out.println(Arrays.toString(in));
        // System.out.println(Arrays.toString(weight));

        for(int[] q:queries){
            if(q[0]==1){
                int u=q[1]-1;
                int v=q[2]-1;
                int w1=q[3];
                int c=-1;
                if(par[u]==v)c=u;
                else c=v;
                int change=w1-weight[c];
                // System.out.println(c);
                weight[c]=w1;
                update(1,0,n-1,in[c],out[c],change);
            }else{
                
                int x=q[1]-1;
                ans.add(query(1,0,n-1,in[x]));
            }
        //     System.out.println(Arrays.toString(tree));
        // System.out.println(Arrays.toString(arr));
        }
        int[] a=new int[ans.size()];
        for(int i=0;i<a.length;i++){
            a[i]=ans.get(i);
        }
        return a;
    }
}