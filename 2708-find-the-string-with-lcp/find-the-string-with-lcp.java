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
        if(com1!=com2){
            par[com1]=com2;
        }
    }
    public String findTheString(int[][] arr) {
        int n=arr.length;
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    if(arr[i][j]!=n-i)return "";
                }else{
                    if(arr[i][j]!=arr[j][i] || arr[i][j]>Math.min(n-i,n-j))return "";
                }
                if(i>0 && j>0){
                    if(arr[i-1][j-1]!=0){
                        if(arr[i-1][j-1]-1!=arr[i][j]){
                            return "";
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i][j]!=0){
                    union(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i][j]==0 && find(i)==find(j)){
                    return "";
                }
            }
        }
        int[] map=new int[n+1];
        int al=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int p=find(i);
            if(map[p]==0){
                if(al==27){
                    return "";
                }
                map[p]=al;
                al++;
            }
            sb.append((char)((map[p]-1)+'a'));
        }
        return sb.toString();
    }
}