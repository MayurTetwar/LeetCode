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
    public int countCompleteComponents(int n, int[][] arr) {
        int m=arr.length;
        par=new int[n];
        List<Integer>[] size=new ArrayList[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=new ArrayList<>();
        }
        for(int[] a:arr){
            union(a[0],a[1]);
        }
        for(int i=0;i<n;i++){
            int p=find(i);
            size[p].add(i);
        }
        int ans=0;
        for(List<Integer> list:size){
            int s=list.size();
            boolean flag=true;
            for(int num:list){
                int count=0;
                for(int[] a:arr){
                    if(a[0]==num || a[1]==num)count++;
                }
                if(count!=s-1){
                    flag=false;
                    break;
                }
            }
            if(s>0 && flag)ans++;
        }
        return ans;
    }
}