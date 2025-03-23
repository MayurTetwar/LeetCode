class Solution {
    public int numberOfComponents(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(inter(arr[i],arr[j],k)){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        boolean[] visi=new boolean[101];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visi[i]){
                dfs(i,list,visi);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>> list,boolean[] visi){
        visi[node]=true;
        for(int num:list.get(node)){
            if(!visi[num]){
                dfs(num,list,visi);
            }
        }
    }
    public boolean inter(int a[],int b[],int k){
        boolean []set=new boolean[101];
        for(int i=0;i<a.length;i++){
            set[a[i]]=true;
        }
        int count=0;
        boolean []set2=new boolean[101];
        for(int i=0;i<b.length;i++){
            if(set[b[i]] && !set2[b[i]]){
                count++;
                set2[b[i]]=true;
            }
            if(count>=k){
               return true; 
            }
        }
        return false;
    }
}