class TreeAncestor {

    int[] depth;
    int[][] up;
    int log;
    List<List<Integer>> list;
    public TreeAncestor(int n, int[] par) {
        log=0;
        list=new ArrayList<>();
        while(n>=(1<<log))log++;

        up=new int[n][log+1];
        for(int i=0;i<n;i++){
            Arrays.fill(up[i],-1);
            list.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            list.get(par[i]).add(i);
        }
        depth=new int[n+1];
        depth[0]=1;
        dfs(0,-1);

        for(int j=1;j<=log;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]!=-1){
                    up[i][j]=up[up[i][j-1]][j-1];
                }
            }
        }
    }
    public void dfs(int curr,int par){
        up[curr][0]=par;
        for(int ch:list.get(curr)){
            depth[ch]=depth[curr]+1;
            dfs(ch,curr);
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=log;i>=0;i--){
            if(node==-1)return -1;
            if((k&(1<<i))!=0){
                node=up[node][i];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */