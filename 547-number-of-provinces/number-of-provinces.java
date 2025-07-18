class Solution {
    int[] par;
    int com;
    public int find(int x){
        if(x!=par[x]){
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
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        com=n;
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    union(i,j);
                }
            }
        }
        return com;
    }
}