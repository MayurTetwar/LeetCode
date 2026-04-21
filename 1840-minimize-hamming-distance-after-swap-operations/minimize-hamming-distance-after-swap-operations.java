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
    public int minimumHammingDistance(int[] arr, int[] tar, int[][] all) {
        int n=arr.length;
        par=new int[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            par[i]=i;
            list.add(new ArrayList<>());
        }
        for(int[] p:all){
            union(p[0],p[1]);
        }
        for(int i=0;i<n;i++){
            list.get(find(i)).add(i);
        }
        int ans=0;
        for(List<Integer> l:list){
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
            for(int i:l){
                l1.add(arr[i]);
                l2.add(tar[i]);
            }
            Collections.sort(l1);
            Collections.sort(l2);
            int i=0,j=0;
            int match=0;
            while(i<l.size() && j<l.size()){
                if(l1.get(i).equals(l2.get(j))){
                    match++;
                    i++;
                    j++;
                }else if(l1.get(i)<l2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
            ans+=l.size()-match;
        }
        return ans;
    }
}