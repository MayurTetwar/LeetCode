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
        if(com1==com2)return ;
        par[com1]=com2;
    }
    public boolean equationsPossible(String[] arr) {
        int n=arr.length;
        par=new int[26];
        for(int i=0;i<26;i++)par[i]=i;
        for(int i=0;i<n;i++){
            if(arr[i].charAt(1)=='='){
                union(arr[i].charAt(0)-'a',arr[i].charAt(3)-'a');
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i].charAt(1)=='!'){
                if(find(arr[i].charAt(0)-'a')==find(arr[i].charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}