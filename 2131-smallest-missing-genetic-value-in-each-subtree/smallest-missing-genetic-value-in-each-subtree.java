class Solution {
    HashSet<Integer> set;
    public int[] smallestMissingValueSubtree(int[] par, int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        set=new HashSet<>();
        Arrays.fill(ans,1);
        List<List<Integer>> list=new ArrayList<>();
        int idx=-1;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            if(arr[i]==1)idx=i;
        }
        for(int i=0;i<n;i++){
            if(par[i]==-1)continue;
            list.get(par[i]).add(i);
        }
        int curr=1;
        int prev=-1;
        while(idx>=0){
            for(int next:list.get(idx)){
                if(next!=prev)
                    dfs(list,arr,next);
            }
            set.add(arr[idx]);
            while(set.contains(curr))curr++;
            ans[idx]=curr;
            prev=idx;
            idx=par[idx];
        }
        return ans;
    }
    public void dfs(List<List<Integer>> list,int[] arr,int curr){
        set.add(arr[curr]);
        for(int next:list.get(curr)){
            dfs(list,arr,next);
        }
    }
}