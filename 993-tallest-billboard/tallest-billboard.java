class Solution {
    int[][] memo;
    public int tallestBillboard(int[] arr) {
        int n=arr.length;
        memo=new int[arr.length][10001];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(arr,0,0);
    }
    public int helper(int[] arr,int i,int sum){
        if(i==arr.length){
            if(sum==0)return 0;
            return Integer.MIN_VALUE;
        }
        if(memo[i][sum+5000]!=-1)return memo[i][sum+5000];
        int val1=helper(arr,i+1,sum);
        int val2=helper(arr,i+1,sum+arr[i])+arr[i];
        int val3=helper(arr,i+1,sum-arr[i]);
        return memo[i][sum+5000]=Math.max(Math.max(val1,val2),val3);
    }
}