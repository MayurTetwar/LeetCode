class TreeAncestor {

    int[][] up;
    int log;
    public TreeAncestor(int n, int[] par) {
        log=0;
        while(n>=(1<<log))log++;
        up=new int[n][log+1];
        for(int i=0;i<n;i++){
            up[i][0]=par[i];
        }
        for(int j=1;j<=log;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]!=-1){
                    up[i][j]=up[up[i][j-1]][j-1];
                }else{
                    up[i][j]=-1;
                }
            }
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