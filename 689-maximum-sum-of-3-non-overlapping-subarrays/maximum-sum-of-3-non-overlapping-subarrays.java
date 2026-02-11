class Solution {
    int n;
    long[][] memo;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        n=nums.length;
        long[] arr=new long[n];
        memo=new long[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                memo[i][j]=-1;
            }
        }
        for(int i=0;i<k;i++){
            arr[0]+=nums[i];
        }
        for(int i=1;i+k-1<n;i++){
            arr[i]=arr[i-1]-nums[i-1]+nums[i+k-1];
        }
        helper(arr,0,3,k);
        List<Integer> ans=new ArrayList<>();
        dfs(arr,0,3,k,ans);
        return new int[]{ans.get(0),ans.get(1),ans.get(2)};
    }
    public void dfs(long[] arr,int i,int group,int k,List<Integer> ans){
        if(group==0 || i==arr.length)return;
        long res1=helper(arr,i+1,group,k);
        long res2=arr[i]+helper(arr,i+k,group-1,k);

        if(res2>=res1){
            ans.add(i);
            dfs(arr,i+k,group-1,k,ans);
        }else{
            dfs(arr,i+1,group,k,ans);
        }
    }
    public long helper(long[] arr,int i,int group,int k){
        if(n==i || group==0)return 0;

        if(memo[i][group]!=-1)return memo[i][group];

        long res=helper(arr,i+1,group,k);
        if(i+k<=n)res=Math.max(res,arr[i]+helper(arr,i+k,group-1,k));
        return memo[i][group]=res;
    }
}