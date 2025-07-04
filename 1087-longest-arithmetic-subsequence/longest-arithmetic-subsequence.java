class Solution {
    int[][] memo;
    public int longestArithSeqLength(int[] arr) {
        int ans=0;
        int n=arr.length;
        memo=new int[n][1001];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],1000);
        }
        for(int i=0;i<n;i++){
            ans=Math.max(ans,helper(arr,i,1000));
        }
        return Math.max(2,ans);
    }
    public int helper(int[] arr,int i,int diff){
        if(i==arr.length){
            return 0;
        }
        if(diff!=1000 && memo[i][diff+500]!=1000)return memo[i][diff+500];
        int ans=1;
        for(int j=i+1;j<arr.length;j++){
            if(diff==1000 || diff==arr[j]-arr[i])
                ans=Math.max(ans,1+helper(arr,j,arr[j]-arr[i]));
        }
        if(diff!=1000)memo[i][diff+500]=ans;
        return ans;
    }
}