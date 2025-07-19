class Solution {
    int n;
    int[] par;
    int[] visi;
    public int find(int x){
        if(par[x]!=x){
            return find(par[x]);
        }
        return x;
    }
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1==com2)return ;
        par[com1]=com2;
    }
    public int[] findRedundantDirectedConnection(int[][] a) {
        int[] ans=new int[2];
        n=a.length;
        for(int i=n-1;i>=0;i--){
            par=new int[n+1];
            for(int j=0;j<=n;j++)par[j]=j;
            visi=new int[n+1];
            for(int j=0;j<n;j++){
                if(i==j)continue;
                union(a[j][0],a[j][1]);
                visi[a[j][1]]++;
            }
            int j=1;
            int parent=find(j);
            if(visi[j]>1)continue;
            // System.out.println(parent);
            for(j=2;j<=n;j++){
            // System.out.println(find(j));
                if(parent!=find(j) || visi[j]>1){
                    break;
                }
            }
            if(j==n+1)return a[i];
        }
        return ans;
    }
    /*
      4 -> 2 -> 1 <- 3

    */
}