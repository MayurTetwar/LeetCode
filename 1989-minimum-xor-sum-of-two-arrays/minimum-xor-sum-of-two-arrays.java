class Solution {
    int n;
    int[][] memo;
    public int minimumXORSum(int[] arr1, int[] arr2) {
        n=arr1.length;
        memo=new int[n][1<<n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(arr1,arr2,0,0);
    }
    public int helper(int[] arr1,int[] arr2,int i,int mask){
        if(i==arr1.length){
            return 0;
        }
        if(memo[i][mask]!=-1)return memo[i][mask];
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            if((mask&(1<<j))==0){
                int val=arr2[j]^arr1[i];
                ans=Math.min(ans,val+helper(arr1,arr2,i+1,mask|(1<<j)));
            }
        }
        return memo[i][mask]=ans;
    }
}