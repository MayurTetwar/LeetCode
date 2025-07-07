class Solution {
    int[] par;
    int n;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public int[] findRedundantConnection(int[][] arr) {
        int[] ans=new int[2];
        n=arr.length;
        par=new int[n+1];
        for(int i=1;i<=n;i++){
            par[i]=i;
        }
        for(int[] a:arr){
            int com1=find(a[0]);
            int com2=find(a[1]);
            if(com1!=com2){
                par[com1]=com2;
            }else{
                ans=a;
            }
        }
        return ans;
    }
}