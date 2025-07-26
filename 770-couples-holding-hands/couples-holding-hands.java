class Solution {
    int[] par;
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
    }
    public int minSwapsCouples(int[] arr) {
        int n=arr.length;
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;
        for(int i=0;i<n;i+=2){
            union(arr[i],arr[i+1]);
        }
        int ans=0;
        for(int i=0;i<n;i+=2){
            if(find(i)!=find(i+1)){
                union(i,i+1);
                ans++;
            }
        }
        return ans;
    }
}