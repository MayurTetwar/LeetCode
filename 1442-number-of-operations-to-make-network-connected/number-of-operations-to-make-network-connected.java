class Solution {
    int[] par;
    int com;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1==com2)return;
        par[com1]=com2;
        com--;
    }
    public int makeConnected(int n, int[][] arr) {
        par=new int[n];
        com=n;
        for(int i=0;i<n;i++)par[i]=i;
        if(arr.length<n-1)return -1;
        for(int[] a:arr){
            union(a[0],a[1]);
        }
        return com-1;
    }
}