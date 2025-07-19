class Solution {
    int n;
    int[] par;
    int[] visi;
    int com;
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
        com--;
    }
    public int[] findRedundantDirectedConnection(int[][] a) {
        int[] ans=new int[2];
        n=a.length;
        com=a.length;
        for(int i=n-1;i>=0;i--){
            par=new int[n+1];
            for(int j=0;j<=n;j++)par[j]=j;
            com=n;
            visi=new int[n+1];
            boolean isValid=true;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                union(a[j][0],a[j][1]);
                visi[a[j][1]]++;
                if(visi[a[j][1]]>1){
                    isValid=false;
                    break;
                }
            }
            if(com==1 && isValid)return a[i];
        }
        return ans;
    }
    /*
      4 -> 2 -> 1 <- 3

    */
}