class Solution {
    int[] par;
    int n;
    public int find(int x){
        if(x!=par[x]){
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
    public int longestConsecutive(int[] arr) {
        n=arr.length;
        par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                continue;
            }
            if(map.containsKey(arr[i]-1)){
                union(i,map.get(arr[i]-1));
            }
            
            if(map.containsKey(arr[i]+1)){
                union(i,map.get(arr[i]+1));
            }
            map.put(arr[i],i);
        }
        int max=0;
        int[] count=new int[n];
        for(int i=0;i<n;i++){
            int root=find(i);
            count[root]++;
            max=Math.max(max,count[root]);
        }
        return max;
    }
}